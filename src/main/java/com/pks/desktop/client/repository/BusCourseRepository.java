package com.pks.desktop.client.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pks.desktop.client.model.BusCourse;

public interface BusCourseRepository extends CrudRepository<BusCourse, Integer>  {
	List<BusCourse> findAllByStartStopCityAndEndStopCity(String startStopCity,String endStopCity);
	BusCourse findCourseById(int id);
}
