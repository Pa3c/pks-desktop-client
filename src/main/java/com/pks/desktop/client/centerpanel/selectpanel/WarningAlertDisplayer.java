package com.pks.desktop.client.centerpanel.selectpanel;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WarningAlertDisplayer {
	public WarningAlertDisplayer(String title,String header,String context) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(context);
		alert.showAndWait();
	}
}
