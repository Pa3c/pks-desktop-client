package com.pks.desktop.client.menu;

import org.springframework.stereotype.Controller;

import com.pks.desktop.client.application.DataStorage;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

@Controller
public class MenuBarController {

	@FXML
	private Menu openMenu,optionsMenu;

	private MenuBarListener menuBarListener;

	@FXML
	private void initialize() {
		if(DataStorage.getUser()==null)
			return;
		
		MenuItem logoutItem = new MenuItem("Wyloguj się");
		logoutItem.setOnAction(x->{
			DataStorage.setUser(null);
			menuBarListener.logout();
		});
		optionsMenu.getItems().add(logoutItem);
		
		
		if (!DataStorage.getUser().getRole().getRole().equals("Admin"))
			return;

		MenuItem openAdmin = new MenuItem("Panel Administracyjny");
		openAdmin.setOnAction(x -> openAdminPanel());
		openMenu.getItems().add(openAdmin);
	}

	public void setMenuBarListener(MenuBarListener menuBarListener) {
		this.menuBarListener = menuBarListener;
	}

	public MenuBarListener getMenuBarListener() {
		return menuBarListener;
	}

	@FXML
	private void openSearchPanel() {
		if (menuBarListener == null)
			return;
		menuBarListener.openSearchPanel();
	}

	private void openAdminPanel() {
		if (menuBarListener == null)
			return;
		menuBarListener.openAdminPanel();
	}

}
