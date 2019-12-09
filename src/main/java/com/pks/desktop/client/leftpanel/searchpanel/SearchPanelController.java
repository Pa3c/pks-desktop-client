package com.pks.desktop.client.leftpanel.searchpanel;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;

@Controller
@Scope("singleton")
public class SearchPanelController {

	@FXML
	private TextField fromField;

	@FXML
	private TextField toField;

	@FXML
	private Button searchButton;

	private SearchPanelListener leftPanelListener;

	public void registerLeftPanelListener(SearchPanelListener leftPanelListener) {
		this.leftPanelListener = leftPanelListener;

		if (leftPanelListener == null)
			return;
		searchButton
				.setOnAction(x -> leftPanelListener.forwardTextFromInputFields(fromField.getText(), toField.getText()));
	}

}
