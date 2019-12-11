package com.pks.desktop.client.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Track implements Serializable {
	
	
	@Id
	@Column(name = "id_stop")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "id_stop")
	private BusStop busStop;

	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "id_course")
	private BusCourse busCourse;

	@Column(nullable = false)
	private Time arrival;
	@Column(nullable = false)
	private Time departure;
	@Column(name = "ticket_price")
	private double ticketPrice;

	@Column(name = "stop_number")
	private int stopNumber;
}
