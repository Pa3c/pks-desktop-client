package com.pks.desktop.client.centerpanel.managepanel.AUTOBUS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.service.BusService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Controller
public class AutobusPanelController {

	@Autowired
	private BusService busService;
	@FXML
	private TextField brandField, modelField, freePlacesField;

	@FXML
	private void addEntity() {
		if(validate())
		busService.save(brandField.getText(), modelField.getText(),freePlacesField.getText());
	}

	private boolean validate() {
		if (brandField.getText().isEmpty() || brandField.getText().isEmpty())
			return false;

		try {
			Integer.parseInt(freePlacesField.getText());
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
