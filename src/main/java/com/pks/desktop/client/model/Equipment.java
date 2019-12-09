package com.pks.desktop.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Equipment {

	@Id
	@Column(name = "id_equipment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(nullable = false)
	private String name;

	@ManyToMany(mappedBy = "equipments",fetch = FetchType.EAGER)
	private List<Bus> buses;
}
