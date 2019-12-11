package com.pks.desktop.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.User;
import com.pks.desktop.client.model.UserRole;
import com.pks.desktop.client.repository.UserRepository;
import com.pks.desktop.client.table.model.UserTableModel;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User login(String login, String password) {
		return userRepository.findByLoginOrEmailAndPassword(login, login, password);
	}

	public void register(String login, String email, String name, String surname, String password) {
		if (login == null || login.isEmpty())
			return;
		if (email == null || email.isEmpty())
			return;
		if (name == null || name.isEmpty())
			return;
		if (surname == null || surname.isEmpty())
			return;
		if (password == null || password.isEmpty())
			return;

		User u = new User();
		u.setLogin(login);
		u.setEmail(email);
		u.setName(surname);
		u.setSurname(surname);
		u.setPassword(password);
		u.setRole(new UserRole("Common"));

		userRepository.save(u);
	}

	public void save(String login, String email, String name, String surname, String password, UserRole role) {
		if (login == null || login.isEmpty())
			return;
		if (email == null || email.isEmpty())
			return;
		if (name == null || name.isEmpty())
			return;
		if (surname == null || surname.isEmpty())
			return;
		if (password == null || password.isEmpty())
			return;
		if (role == null || role.getRole().isEmpty())
			return;

		User u = new User();
		u.setLogin(login);
		u.setEmail(email);
		u.setName(surname);
		u.setSurname(surname);
		u.setPassword(password);
		u.setRole(role);

		userRepository.save(u);
	}

	public List<UserTableModel> getTableModels() {
		List<UserTableModel> listModel = new ArrayList<UserTableModel>();
		userRepository.findAll().forEach(x -> listModel.add(new UserTableModel(x.getId(), x.getName(), x.getSurname(),
				x.getEmail(), x.getLogin(), x.getPassword(), x.getBalanceAccount())));
		return listModel;
	}

	public void delete(int id) {
		userRepository.deleteById(id);

	}

}
