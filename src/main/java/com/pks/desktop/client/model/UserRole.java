package com.pks.desktop.client.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class UserRole {

	@Id
	private String role;
	@OneToMany(mappedBy = "role")
	private List<User> users;

	public UserRole() {
	}

	public void addUser(User u) {
		users.add(u);
		u.setRole(this);
	}

	public void removerUser(User u) {
		users.remove(u);
		u.setRole(null);
	}

	public UserRole(String role) {
		this.role = role;
	}

}
