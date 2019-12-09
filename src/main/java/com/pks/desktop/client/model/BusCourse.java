package com.pks.desktop.client.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bus_course")
@Getter
@Setter
@Embeddable
public class BusCourse {
	@Id
	@Column(name = "id_course")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_driver")
	private Driver driver;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bus")
	private Bus bus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "start_stop")
	private BusStop startStop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "end_stop")
	private BusStop endStop;
	@Column(nullable = false)
	private String signature;
	
	private String description;

	@Column(name = "begin_time")
	private Time beginTime;

	@Column(name = "end_time")
	private Time endTime;

	@OneToMany(mappedBy = "busCourse")
	private List<Track> tracks;

	public void addTrack(Track t) {
		tracks.add(t);
		t.setBusCourse(this);
	}

	public void removeTrack(Track t) {
		tracks.remove(t);
		t.setBusCourse(null);
	}
	
	@OneToMany(mappedBy = "busCourse", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PassengerLog> passengers;
}
