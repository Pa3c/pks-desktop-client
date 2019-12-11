package com.pks.desktop.client.centerpanel.managepanel.WYPOSAZENIE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.service.EquipmentService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Controller
public class WyposazeniePanelController {

	@Autowired
	private EquipmentService equipmentService;

	@FXML
	private TextField nameField;

	@FXML
	private void addEntity() {
		if(validate())
			equipmentService.save(nameField.getText());
	}

	private boolean validate() {
		if (nameField.getText().isEmpty())
			return false;
		return true;
	}
}
