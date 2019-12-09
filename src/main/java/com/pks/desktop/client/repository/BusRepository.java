package com.pks.desktop.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pks.desktop.client.model.Bus;

@Repository
public interface BusRepository extends CrudRepository<Bus, Integer>{
}
