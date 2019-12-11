package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Equipment;
import com.pks.desktop.client.repository.EquipmentRepository;
import com.pks.desktop.client.table.model.EquipmentTableModel;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;

	public void save(String text) {
		Equipment eq = new Equipment();
		eq.setName(text);
		equipmentRepository.save(eq);
	}

	public List<EquipmentTableModel> getTableModels() {
		List<EquipmentTableModel> listModel = new ArrayList<>();

		equipmentRepository.findAll().forEach(x -> listModel.add(new EquipmentTableModel(x.getId(), x.getName())));

		return listModel;
	}

	public void delete(int id) {
		equipmentRepository.deleteById(id);
	}

}
