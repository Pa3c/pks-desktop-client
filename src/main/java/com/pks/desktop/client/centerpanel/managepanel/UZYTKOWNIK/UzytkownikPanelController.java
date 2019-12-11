package com.pks.desktop.client.centerpanel.managepanel.UZYTKOWNIK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.model.UserRole;
import com.pks.desktop.client.service.UserRoleService;
import com.pks.desktop.client.service.UserService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

@Controller
public class UzytkownikPanelController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@FXML
	private TextField loginField, nameField, surnameField, passwordField, emailField;

	@FXML
	private ComboBox<UserRole> roleCombo;

	@FXML
	private void initialize() {
		ObservableList<UserRole> list = FXCollections.observableArrayList(userRoleService.findAll());
		roleCombo.setItems(list);
		roleCombo.getSelectionModel().select(0);
	}

	@FXML
	private void addEntity() {
		if (validate()) {
			userService.save(loginField.getText(), emailField.getText(), nameField.getText(), surnameField.getText(),
					passwordField.getText(), roleCombo.getSelectionModel().getSelectedItem());
		}

	}

	private boolean validate() {
		if (nameField.getText().isEmpty() || surnameField.getText().isEmpty() || passwordField.getText().isEmpty()
				|| emailField.getText().isEmpty() || loginField.getText().isEmpty())
			return false;

		if (!emailField.getText().matches("^.+@.+\\.[a-zA-Z]{1,}$"))
			return false;

		return true;
	}
}
