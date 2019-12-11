package com.pks.desktop.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.pks.desktop.client.model.BusStop;

public interface BusStopRepository extends CrudRepository<BusStop, Integer> {
}
