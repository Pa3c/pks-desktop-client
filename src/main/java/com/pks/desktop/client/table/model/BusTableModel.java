package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BusTableModel {
	private final SimpleStringProperty brand, model;
	private final SimpleIntegerProperty id, freePlaces;

	public BusTableModel(Integer id, String brand, String model, Integer freePlaces) {
		this.id = new SimpleIntegerProperty(id);
		this.brand = new SimpleStringProperty(brand);
		this.model = new SimpleStringProperty(model);
		this.freePlaces = new SimpleIntegerProperty(freePlaces);
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


	public int getfreePlaces() {
		return freePlaces.get();
	}

}
