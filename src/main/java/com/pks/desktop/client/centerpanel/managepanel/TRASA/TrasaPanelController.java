package com.pks.desktop.client.centerpanel.managepanel.TRASA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.service.TrackService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Controller
public class TrasaPanelController {

	@Autowired
	private TrackService trackService;

	@FXML
	private TextField busStopField,busCourseIdField, arrivalField, departureField, ticketField, numberField;

	@FXML
	private void addEntity() {
		if (validate())
			trackService.addTrack(busStopField.getText(),busCourseIdField.getText(),
					arrivalField.getText(),
					departureField.getText(),
					ticketField.getText(), numberField.getText());
	}

	private boolean validate() {
		String regex = "^([0-1][0-9]|[2][0-3])[:][0-5][0-9]$";
		if (!arrivalField.getText().matches(regex))
			return false;
		if (!departureField.getText().matches(regex))
			return false;
		if (!ticketField.getText().matches("^[+]?\\d+([.]\\d+)?$"))
			return false;
		if (!numberField.getText().matches("^[+]?\\d+?$"))
			return false;
		if (!busCourseIdField.getText().matches("^[+]?\\d+?$"))
			return false;
		if (!busStopField.getText().matches("^[+]?\\d+?$"))
			return false;
		return true;
	}
}
