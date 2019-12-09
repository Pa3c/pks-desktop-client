package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.BusCourse;
import com.pks.desktop.client.model.Track;
import com.pks.desktop.client.repository.BusCourseRepository;
import com.pks.desktop.client.table.model.BusCourseTableModel;

@Service
public class BusCourseService {
	
	@Autowired
	private BusCourseRepository busCourseRepository;
	
	@Transactional
	public List<BusCourseTableModel> getBusCourseTableModelListByCities(String startStopCity,String endStopCity){
		List<BusCourseTableModel> list = new ArrayList<>();
				busCourseRepository
				.findAllByStartStopCityAndEndStopCity(startStopCity, endStopCity)
				.forEach(x->list.add(
						new BusCourseTableModel(
								x.getId(),
								x.getStartStop().getCity(),
								x.getEndStop().getCity(),
								x.getBeginTime().toString(),
								x.getEndTime().toString(),
								x.getDriver().getName()+" "+x.getDriver().getSurname(),
								x.getBus().getBrand(),
								String.valueOf(
										x.getTracks()
										.stream()
										.filter(t->t.getBusCourse().getId()==x.getId())
										.mapToDouble(Track::getTicketPrice)
										.sum()
										)
									)
						));
				return list;
	}
	
	public BusCourse findBusCourseById(int id) {
		return busCourseRepository.findCourseById(id);
	}

}
