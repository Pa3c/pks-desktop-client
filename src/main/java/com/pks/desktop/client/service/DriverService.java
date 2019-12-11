package com.pks.desktop.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Driver;
import com.pks.desktop.client.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepostory;

	public void save(String name, String surname) {
		Driver d = new Driver();
		d.setName(name);
		d.setSurname(surname);
		driverRepostory.save(d);
	}

}
