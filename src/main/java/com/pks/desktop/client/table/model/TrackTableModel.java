package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TrackTableModel {
	private final SimpleStringProperty arrival,departure;
	private final SimpleIntegerProperty id, user, busCourse;
	private final SimpleDoubleProperty price;

	public TrackTableModel(Integer id, String arrival,String departure,Integer user, Integer busCourse, Double price) {
		this.id = new SimpleIntegerProperty(id);
		this.user = new SimpleIntegerProperty(user);
		this.busCourse = new SimpleIntegerProperty(busCourse);
		this.arrival = new SimpleStringProperty(arrival);
		this.departure = new SimpleStringProperty(departure);
		this.price = new SimpleDoubleProperty(price);
	}

	public int getId() {
		return id.get();
	}

	public String getArrival() {
		return arrival.get();
	}
	public String getDeparture() {
		return departure.get();
	}

	public int getAmount() {
		return user.get();
	}

	public int getBusCourse() {
		return busCourse.get();
	}

	public double getPrice() {
		return price.get();
	}
}
