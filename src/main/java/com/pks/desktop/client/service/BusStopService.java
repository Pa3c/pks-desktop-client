package com.pks.desktop.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.BusStop;
import com.pks.desktop.client.repository.BusStopRepository;

@Service
public class BusStopService {

	@Autowired
	private BusStopRepository busStopRepository;
	public void save(String cityField, String streetField) {
		BusStop bs = new BusStop();
		bs.setCity(cityField);
		bs.setStreet(streetField);
		busStopRepository.save(bs);
	}

}
