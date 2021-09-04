package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	IUserRepository userRepo;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public Iterable<User> getAll() {
	return userRepo.findAll();
	}
	
	@Override
	public void deleteUser(Integer id) {
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		userRepo.deleteById(id);
		
	}
	
	@Override
	public User updateUser(Integer id,User user1) {
		Optional<User> user = userRepo.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		User us=user.get();
		if(StringUtils.hasText(user1.getName())) {
			us.setName(user1.getName());
		}
		return userRepo.save(us);
	}
}
