package com.pks.desktop.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.pks.desktop.client.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByLoginOrEmailAndPassword(String login,String email, String password);
}
