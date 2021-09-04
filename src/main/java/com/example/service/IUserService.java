package com.example.service;

import javax.validation.Valid;

import com.example.entity.User;

public interface IUserService {

	User saveUser(@Valid User user);

	Iterable<User> getAll();

	void deleteUser(Integer id);

	User updateUser(Integer id, User user);

}
