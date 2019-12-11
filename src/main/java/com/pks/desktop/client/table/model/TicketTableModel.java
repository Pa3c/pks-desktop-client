package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TicketTableModel {
	private final SimpleStringProperty date;
	private final SimpleIntegerProperty id, user, busCourse;
	private final SimpleDoubleProperty price;

	public TicketTableModel(Integer id, String date, Integer user, Integer busCourse, Double price) {
		this.id = new SimpleIntegerProperty(id);
		this.user = new SimpleIntegerProperty(user);
		this.busCourse = new SimpleIntegerProperty(busCourse);
		this.date = new SimpleStringProperty(date);
		this.price = new SimpleDoubleProperty(price);
	}

	public int getId() {
		return id.get();
	}

	public String getDate() {
		return date.get();
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
