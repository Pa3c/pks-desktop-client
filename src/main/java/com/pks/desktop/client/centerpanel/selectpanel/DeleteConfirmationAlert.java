package com.pks.desktop.client.centerpanel.selectpanel;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DeleteConfirmationAlert {
	
	Alert alert;
	
	public DeleteConfirmationAlert() {
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deleting confirmation");
		alert.setHeaderText("Are you sure to delete this record ?");
		alert.setContentText(null);
	}
	public Alert getAlert() {
		return alert;
	}
}
