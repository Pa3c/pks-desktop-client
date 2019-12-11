package com.pks.desktop.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.UserRole;
import com.pks.desktop.client.repository.UserRoleRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public List<UserRole> findAll(){
		return userRoleRepository.findAll();
	}
}
