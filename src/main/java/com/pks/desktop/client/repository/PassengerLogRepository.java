package com.pks.desktop.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.pks.desktop.client.model.Driver;
import com.pks.desktop.client.model.PassengerLog;

public interface PassengerLogRepository extends CrudRepository<PassengerLog, Integer> {
}
