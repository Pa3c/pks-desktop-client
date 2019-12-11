package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserTableModel {
	private final SimpleStringProperty name, surname, email, login, password;
	private final SimpleIntegerProperty id;
	private final SimpleDoubleProperty balanceAccount;

	public UserTableModel(Integer id, String name, String surname, String email, String login, String password,
			Double balanceAccount) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		this.email = new SimpleStringProperty(email);
		this.login = new SimpleStringProperty(login);
		this.password = new SimpleStringProperty(password);
		this.balanceAccount = new SimpleDoubleProperty(balanceAccount);
	}

	public int getId() {
		return id.get();
	}

	public String getSurname() {
		return surname.get();
	}

	public String getName() {
		return name.get();
	}

	public double getBalanceAccount() {
		return balanceAccount.get();
	}

	public String getEmail() {
		return email.get();
	}

	public String getLogin() {
		return login.get();
	}

	public String getPassword() {
		return password.get();
	}

}
