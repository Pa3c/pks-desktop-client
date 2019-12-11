package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.BusStop;
import com.pks.desktop.client.repository.BusStopRepository;
import com.pks.desktop.client.table.model.BusStopTableModel;

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

	public void delete(int id) {
		busStopRepository.deleteById(id);
	}

	public List<BusStopTableModel> getTableModels() {
		List<BusStop> list = (List<BusStop>) busStopRepository.findAll();
		List<BusStopTableModel> listmodel = new ArrayList<>();
		list.forEach(x -> listmodel.add(new BusStopTableModel(x.getId(), x.getCity(), x.getStreet())));
		return listmodel;
	}

}
