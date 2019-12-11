package com.pks.desktop.client.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pks.desktop.client.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, String> {
	List<UserRole> findAll();
}
