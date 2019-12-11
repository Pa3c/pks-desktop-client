package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DriverTableModel {
	private final SimpleStringProperty name, surname;
	private final SimpleIntegerProperty id;

	public DriverTableModel(Integer id, String name, String surname) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
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


}
