package com.pks.desktop.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Bus;
import com.pks.desktop.client.repository.BusRepository;


@Service
public class BusService {

	@Autowired
	private BusRepository busRepository;

	public void save(String brand, String model, String freePlaces) {
		Bus b = new Bus();
		b.setBrand(brand);
		b.setModel(model);
		b.setFreePlaces(Integer.parseInt(freePlaces));
		busRepository.save(b);
	}

}
