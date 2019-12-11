package com.pks.desktop.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Equipment;
import com.pks.desktop.client.repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;

	public void save(String text) {
		Equipment eq = new Equipment();
		eq.setName(text);
		equipmentRepository.save(eq);
	}

}
