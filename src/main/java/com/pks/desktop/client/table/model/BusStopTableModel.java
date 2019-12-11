package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BusStopTableModel {
	private final SimpleStringProperty city, street;
	private final SimpleIntegerProperty id;

	public BusStopTableModel(Integer id, String city, String street) {
		this.id = new SimpleIntegerProperty(id);
		this.city = new SimpleStringProperty(city);
		this.street = new SimpleStringProperty(street);
	}

	public int getId() {
		return id.get();
	}

	public String getCity() {
		return city.get();
	}

	public String getStreet() {
		return street.get();
	}

}
