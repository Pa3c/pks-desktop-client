package com.pks.desktop.client.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Driver {

	@Id
	@Column(name = "id_driver")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;

	@OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<BusCourse> busCourses;

	public void addBusCourses(BusCourse e) {
		busCourses.add(e);
		e.setDriver(this);
	}

	public void removeBusCourses(BusCourse e) {
		busCourses.remove(e);
		e.setDriver(null);
	}

}
