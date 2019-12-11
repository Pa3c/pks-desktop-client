package com.pks.desktop.client.leftpanel.adminpanel;

import java.util.Arrays;

import org.springframework.stereotype.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

@Controller
public class AdminPanelController {
	private static enum Options {
		AUTOBUS, TRASA, WYPOSAZENIE, PRZYSTANEK, KIEROWCA, UZYTKOWNIK
	}

	private static enum Options2 {
		bus, buscourse, busstop, driver, equipment, passengerlog, ticket, user, userrole
	}

	@FXML
	private ListView<Options> addList;
	@FXML
	private ListView<Options2> selectList;
	private AdminPanelListener adminPanelListener;

	@FXML
	private void initialize() {
		addList.setItems(FXCollections.observableArrayList(Arrays.asList(Options.values())));
		addList.setOnMouseClicked(x -> {
			String name = addList.getSelectionModel().getSelectedItem().toString();
			adminPanelListener.setInsertView(name);
		});

		selectList.setItems(FXCollections.observableArrayList(Arrays.asList(Options2.values())));
		selectList.setOnMouseClicked(x -> {
			String name = selectList.getSelectionModel().getSelectedItem().toString();
			adminPanelListener.setSelectView(name);
		});
	}

	public void setAdminPanelListener(AdminPanelListener adminPanelListener) {
		this.adminPanelListener = adminPanelListener;
	}
}
