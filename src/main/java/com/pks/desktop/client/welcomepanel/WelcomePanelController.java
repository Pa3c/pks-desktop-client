package com.pks.desktop.client.welcomepanel;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pks.desktop.client.application.DataStorage;
import com.pks.desktop.client.application.SpringFXMLLoader;
import com.pks.desktop.client.model.User;
import com.pks.desktop.client.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@Controller
public class WelcomePanelController {

	@Autowired
	private UserService userService;
	@FXML
	private TextField emailLoginField, passwordLoginField, loginRegisterField, emailRegisterField, nameRegisterField,
			surnameRegisterField, passwordRegisterField;
	@FXML
	private Button loginButton, registerButton;

	@Autowired
	private SpringFXMLLoader springFXMLLoader;
	
	@FXML
	private void register() {
		String login = loginRegisterField.getText();
		String email = emailRegisterField.getText();
		String name = nameRegisterField.getText();
		String surname = surnameRegisterField.getText();
		String password = passwordRegisterField.getText();
		userService.register(login,email,name,surname,password);
	}

	@FXML
	private void login() throws IOException {
		String loginOrEmail = emailLoginField.getText();
		String password = passwordLoginField.getText();
		User u = userService.login(loginOrEmail, password);
		if (u == null)
			return;
		DataStorage.setUser(u);
		Scene scene = loginButton.getScene();
		scene.setRoot(springFXMLLoader.load("../main/MainLayout.fxml"));
		
	}
}
