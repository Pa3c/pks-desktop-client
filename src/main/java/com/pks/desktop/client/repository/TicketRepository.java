package com.pks.desktop.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.pks.desktop.client.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
