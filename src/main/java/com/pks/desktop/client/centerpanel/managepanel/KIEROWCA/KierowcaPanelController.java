package com.pks.desktop.client.centerpanel.managepanel.KIEROWCA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.service.DriverService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Controller
public class KierowcaPanelController {

	@Autowired
	private DriverService driverService;
	
	@FXML
	private TextField nameField,surnameField;
	
	@FXML
	private void addEntity() {
		if(validate())
			driverService.save(nameField.getText(),surnameField.getText());
	}

	private boolean validate() {
		if(nameField.getText().isEmpty() || surnameField.getText().isEmpty())
		return false;
		
		return true;
	}
}
