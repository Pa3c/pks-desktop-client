package com.pks.desktop.client.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "bus_stop")
@Embeddable
@Getter
@Setter
public class BusStop {

	@Id
	@Column(name = "id_stop")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String street;
	@Column(nullable = false)
	private String city;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, mappedBy = "endStop")
	private List<BusCourse> startsOfCourses;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, mappedBy = "endStop")
	private List<BusCourse> endsOfCourses;

	public void addEndsOfCourses(BusCourse e) {
		endsOfCourses.add(e);
		e.setEndStop(this);
	}

	public void removeEndsOfCourses(BusCourse e) {
		endsOfCourses.remove(e);
		e.setEndStop(null);
	}

	public void addStartsOfCourses(BusCourse e) {
		startsOfCourses.add(e);
		e.setStartStop(this);
	}

	public void removeStartsOfCourses(BusCourse e) {
		startsOfCourses.remove(e);
		e.setStartStop(null);
	}

	@OneToMany(mappedBy = "busStop")
	private List<Track> tracks;

	public void addTrack(Track t) {
		tracks.add(t);
		t.setBusStop(this);
	}

	public void removeTrack(Track t) {
		tracks.remove(t);
		t.setBusStop(null);
	}
}
