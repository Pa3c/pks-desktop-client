package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EquipmentTableModel {
	private final SimpleStringProperty name;
	private final SimpleIntegerProperty id;

	public EquipmentTableModel(Integer id, String name) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
	}

	public int getId() {
		return id.get();
	}

	public String getName() {
		return name.get();
	}

}
