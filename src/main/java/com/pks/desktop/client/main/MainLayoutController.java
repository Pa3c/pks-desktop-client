package com.pks.desktop.client.main;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.application.SpringFXMLLoader;
import com.pks.desktop.client.centerpanel.SearchResultPanelController;
import com.pks.desktop.client.centerpanel.OpacityChanger;
import com.pks.desktop.client.leftpanel.adminpanel.AdminPanelController;
import com.pks.desktop.client.leftpanel.adminpanel.AdminPanelListener;
import com.pks.desktop.client.leftpanel.searchpanel.SearchPanelController;
import com.pks.desktop.client.leftpanel.searchpanel.SearchPanelListener;
import com.pks.desktop.client.menu.MenuBarController;
import com.pks.desktop.client.menu.MenuBarListener;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

@Controller
@Scope("singleton")
public class MainLayoutController implements SearchPanelListener, MenuBarListener, AdminPanelListener {

	@FXML
	private BorderPane mainPane;
	@Autowired
	private SearchPanelController searchPanelController;
	@Autowired
	private SearchResultPanelController searchPanelResultController;
	@Autowired
	private MenuBarController menuBarController;
	@Autowired
	private AdminPanelController adminPanelController;

	@Autowired
	private SpringFXMLLoader springFXMLLoader;

	@FXML
	private void initialize() throws Exception {
		AnimationTimer timer = new OpacityChanger(mainPane);
		timer.start();
		initAppLayout();
	}

	private void initAppLayout() throws IOException {
		initMenuBar();
		initSearchPanel();
		initSearchPanelResult();
	}

	private void initSearchPanelResult() throws IOException {
		mainPane.setCenter(springFXMLLoader.load("../centerpanel/SearchResultPanelLayout.fxml"));
	}

	private void initSearchPanel() throws IOException {
		mainPane.setLeft(springFXMLLoader.load("../leftpanel/searchpanel/SearchPanelLayout.fxml"));
		searchPanelController.registerLeftPanelListener(this);
	}

	private void initMenuBar() throws IOException {
		mainPane.setTop(springFXMLLoader.load("../menu/MenuBar.fxml"));
		menuBarController.setMenuBarListener(this);
	}

	private void initAdminLeftPanel() throws IOException {
		mainPane.setLeft(springFXMLLoader.load("../leftpanel/adminpanel/AdminPanelLayout.fxml"));
		adminPanelController.setAdminPanelListener(this);
	}

	@Override
	public void forwardTextFromInputFields(String startStopCity, String endStopCity) {
		searchPanelResultController.showAvailableCourses(startStopCity, endStopCity);
	}

	@Override
	public void openAdminPanel() {
		try {
			initAdminLeftPanel();
			mainPane.setCenter(new Pane());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void openSearchPanel() {
		try {
			initSearchPanel();
			initSearchPanelResult();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void setInsertView(String name) {
		String path = "../centerpanel/managepanel/" + name + "/" + name + "PanelLayout.fxml";
		try {
			mainPane.setCenter(springFXMLLoader.load(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void setSelectView(String name) {
		
	}

	@Override
	public void logout() {
		try {
			mainPane.getScene().setRoot(springFXMLLoader.load("../welcomepanel/WelcomeLayout.fxml"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
