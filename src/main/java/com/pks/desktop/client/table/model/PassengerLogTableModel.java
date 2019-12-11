package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PassengerLogTableModel {
	private final SimpleStringProperty date;
	private final SimpleIntegerProperty id, amount, busCourse;

	public PassengerLogTableModel(Integer id, String date, Integer amount, Integer busCourse) {
		this.id = new SimpleIntegerProperty(id);
		this.amount = new SimpleIntegerProperty(amount);
		this.busCourse = new SimpleIntegerProperty(busCourse);
		this.date = new SimpleStringProperty(date);
	}

	public int getId() {
		return id.get();
	}

	public String getDate() {
		return date.get();
	}

	public int getAmount() {
		return amount.get();
	}

	public int getBusCourse() {
		return busCourse.get();
	}
}
