package com.pks.desktop.client.service;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.BusCourse;
import com.pks.desktop.client.model.BusStop;
import com.pks.desktop.client.model.Track;
import com.pks.desktop.client.repository.BusCourseRepository;
import com.pks.desktop.client.repository.BusStopRepository;
import com.pks.desktop.client.repository.TrackRepository;

@Service
public class TrackService {

	@Autowired
	private BusCourseRepository busCourseRepository;
	@Autowired
	private BusStopRepository busStopRepository;
	@Autowired
	private TrackRepository trackRepository;

	public void addTrack(String busStopId, String courseId, String arrival, String departure, String ticketPrice,
			String number) {
		BusStop bs = busStopRepository.findById(Integer.valueOf(busStopId)).get();
		BusCourse bc = busCourseRepository.findById(Integer.valueOf(courseId)).get();

		Track t = new Track();
		t.setArrival(Time.valueOf(arrival));
		t.setDeparture(Time.valueOf(departure));
		t.setBusCourse(bc);
		t.setBusStop(bs);
		t.setTicketPrice(Double.valueOf(ticketPrice));
		t.setStopNumber(Integer.valueOf(number));
		trackRepository.save(t);
	}

}
