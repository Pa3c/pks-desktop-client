package com.pks.desktop.client.application;

import com.pks.desktop.client.model.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataStorage {
	@Getter
	@Setter
	private static User user;
}
