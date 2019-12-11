package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Bus;
import com.pks.desktop.client.repository.BusRepository;
import com.pks.desktop.client.table.model.BusTableModel;


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

	public void delete(int id) {
		busRepository.deleteById(id);
	}

	public List<BusTableModel> getTableModels() {
		List<BusTableModel> itemModel = new ArrayList<>();
		busRepository.findAll().forEach(x->itemModel.add(new BusTableModel(x.getId(), x.getBrand(), x.getModel(), x.getFreePlaces())));
		return itemModel;
	}

}
