package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Driver;
import com.pks.desktop.client.repository.DriverRepository;
import com.pks.desktop.client.table.model.DriverTableModel;

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

	public void delete(int id) {
		driverRepostory.deleteById(id);
	}

	public List<DriverTableModel> getTableModels() {
		List<DriverTableModel> listmodel = new ArrayList<>();
		driverRepostory.findAll()
				.forEach(x -> listmodel.add(new DriverTableModel(x.getId(), x.getName(), x.getSurname())));
		return listmodel;

	}

}
