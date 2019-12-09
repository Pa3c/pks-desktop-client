package com.pks.desktop.client.menu;

import org.springframework.stereotype.Controller;

import com.pks.desktop.client.application.DataStorage;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

@Controller
public class MenuBarController {

	@FXML
	private Menu openMenu;

	private MenuBarListener menuBarListener;

	@FXML
	private void initialize() {
		if (!DataStorage.getUser().getRole().getRole().equals("Admin"))
			return;

		MenuItem item = new MenuItem("Panel Administracyjny");
		item.setOnAction(x -> openAdminPanel());
		openMenu.getItems().add(item);
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
