package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.UserRole;
import com.pks.desktop.client.repository.UserRoleRepository;
import com.pks.desktop.client.table.model.UserRoleTableModel;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;

	public List<UserRole> findAll() {
		return userRoleRepository.findAll();
	}

	public void delete(String role) {
		userRoleRepository.deleteById(role);
	}

	public List<UserRoleTableModel> getTableModels() {
		List<UserRoleTableModel> listModel = new ArrayList<UserRoleTableModel>();
		userRoleRepository.findAll().forEach(x -> listModel.add(new UserRoleTableModel(x.getRole())));
		return listModel;
	}
}
