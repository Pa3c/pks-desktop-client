package com.pks.desktop.client.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table
@Getter
@Setter
public class Track implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8096450642149363922L;

	@EmbeddedId
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "id_stop")
	private BusStop busStops;

	@EmbeddedId
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
