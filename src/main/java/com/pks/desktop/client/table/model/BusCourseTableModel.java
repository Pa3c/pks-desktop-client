package com.pks.desktop.client.table.model;

import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BusCourseTableModel {
	private final int id;
	private final SimpleStringProperty from, to, begin, end, driver, bus, price;

	public BusCourseTableModel(int id, String from, String to, String begin, String end, String driver, String bus,
			String price) {
		this.id = id;
		this.from = new SimpleStringProperty(from);
		this.to = new SimpleStringProperty(to);
		this.begin = new SimpleStringProperty(begin);
		this.end = new SimpleStringProperty(end);
		this.driver = new SimpleStringProperty(driver);
		this.bus = new SimpleStringProperty(bus);
		this.price = new SimpleStringProperty(price);
	}

	public int getId() {
		return id;
	}

	public String getBegin() {
		return begin.get();
	}

	public String getFrom() {
		return from.get();
	}

	public String getTo() {
		return to.get();
	}

	public String getEnd() {
		return end.get();
	}

	public String getDriver() {
		return driver.get();
	}

	public String getBus() {
		return bus.get();
	}

	public String getPrice() {
		return price.get();
	}

}
