package com.pks.desktop.client.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Table
@Entity
@Getter
@Setter
public class Bus {

	@Id
	@Column(name = "id_bus")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String model;

	@Column(name = "free_places",nullable = false)
	private int freePlaces;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.EAGER)
	@JoinTable(name = "bus_equipment", joinColumns = @JoinColumn(name = "id_bus"), inverseJoinColumns = @JoinColumn(name = "id_equipment"))
	private List<Equipment> equipments;

	public void addEquipment(Equipment e) {
		equipments.add(e);
		e.getBuses().add(this);
	}

	public void removeEquipment(Equipment e) {
		equipments.remove(e);
		e.getBuses().remove(this);
	}

	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<BusCourse> busCourses;

	public void addBusCourses(BusCourse e) {
		busCourses.add(e);
		e.setBus(this);
	}

	public void removeBusCourses(BusCourse e) {
		busCourses.remove(e);
		e.setBus(null);
	}

}
