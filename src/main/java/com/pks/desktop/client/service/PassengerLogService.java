package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.repository.PassengerLogRepository;
import com.pks.desktop.client.table.model.PassengerLogTableModel;

@Service
public class PassengerLogService {

	@Autowired
	private PassengerLogRepository passengerLogRepository;

	public List<PassengerLogTableModel> getTableModels() {
		List<PassengerLogTableModel> tableModel = new ArrayList<>();

		passengerLogRepository.findAll().forEach(x -> tableModel.add(new PassengerLogTableModel(x.getId(),
				String.valueOf(x.getDate()), x.getAmount(), x.getBusCourse().getId())));

		return tableModel;
	}

	public void delete(int id) {
		passengerLogRepository.deleteById(id);
	}

}
