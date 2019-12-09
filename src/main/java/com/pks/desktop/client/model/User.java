package com.pks.desktop.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@Entity
@Table(name = "user_table")
public class User {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true,nullable = false)
	private String email;
	@Column(unique = true,nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;

	@OneToMany(mappedBy = "user")
	private List<Ticket> tickets;

	public void addTicket(Ticket t) {
		tickets.add(t);
		t.setUser(this);
	}

	public void removeTicket(Ticket t) {
		tickets.remove(t);
		t.setUser(null);
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id")
	private UserRole role;
	@Column(name = "balance_account")
	private double balanceAccount;

}
