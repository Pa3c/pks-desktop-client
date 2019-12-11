package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleStringProperty;

public class UserRoleTableModel {
	private final SimpleStringProperty role;

	public UserRoleTableModel(String role) {
		this.role = new SimpleStringProperty(role);
	}


	public String getRole() {
		return role.get();
	}


}
