package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Ticket;
import com.pks.desktop.client.repository.TicketRepository;
import com.pks.desktop.client.table.model.TicketTableModel;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public void saveTicket(Ticket t) {
		ticketRepository.save(t);
	}

	public void delete(int id) {
		ticketRepository.deleteById(id);
	}

	public List<TicketTableModel> getTableModels() {
		List<TicketTableModel> tableModel = new ArrayList<>();

		ticketRepository.findAll().forEach(x -> tableModel.add(new TicketTableModel(x.getId(), x.getDate().toString(),
				x.getUser().getId(), x.getBusCourse().getId(), x.getPrice())));

		return tableModel;
	}

}
