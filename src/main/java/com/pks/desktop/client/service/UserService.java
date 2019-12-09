package com.pks.desktop.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.desktop.client.model.User;
import com.pks.desktop.client.model.UserRole;
import com.pks.desktop.client.repository.UserRepository;

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

}
