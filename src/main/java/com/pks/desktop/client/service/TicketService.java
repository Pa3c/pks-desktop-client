package com.pks.desktop.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.Ticket;
import com.pks.desktop.client.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	
	public void saveTicket(Ticket t) {
		ticketRepository.save(t);
	}

}
