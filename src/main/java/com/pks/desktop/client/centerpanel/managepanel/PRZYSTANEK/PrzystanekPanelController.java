package com.pks.desktop.client.centerpanel.managepanel.PRZYSTANEK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.service.BusStopService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Controller
public class PrzystanekPanelController {

	@Autowired
	private BusStopService busStopService;
	
	@FXML
	private TextField cityField,streetField;
	
	
	@FXML
	private void addEntity() {
		if(validate())
			busStopService.save(cityField.getText(),streetField.getText());
	}

	private boolean validate() {
		if(cityField.getText().isEmpty() || streetField.getText().isEmpty())
		return false;
		
		return true;
	}
}
