package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BusTableModel {
	private final SimpleStringProperty brand, model;
	private final SimpleIntegerProperty id, freePlaces, equipment;

	public BusTableModel(Integer id, String brand, String model, Integer freePlaces, Integer equipment) {
		this.id = new SimpleIntegerProperty(id);
		this.brand = new SimpleStringProperty(brand);
		this.model = new SimpleStringProperty(model);
		this.freePlaces = new SimpleIntegerProperty(freePlaces);
		this.equipment = new SimpleIntegerProperty(equipment);
	}

	public int getId() {
		return id.get();
	}

	public String getBrand() {
		return brand.get();
	}

	public String getModel() {
		return model.get();
	}

	public int getEquipment() {
		return equipment.get();
	}

	public int getfreePlaces() {
		return freePlaces.get();
	}

}
