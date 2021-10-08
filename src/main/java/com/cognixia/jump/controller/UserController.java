package com.cognixia.jump.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Recent;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.RecentRepository;
import com.cognixia.jump.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RecentRepository recentRepository;
	
	@GetMapping(value = "/user")
	public Iterable<User> all()
	{
		List<User> user = userRepository.findAll();
		
		return user;
	}
	
	@GetMapping(value = "/user/{userId}")
	public User getUserById(@PathVariable("userId") Integer userId)
	{
		User user = userRepository.getUserByuserId(userId);
		
		return user;
	}
	
	@PostMapping(value = "/user/login")
	public User userLogin(@RequestBody User user)
	{
		User logIn = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		return logIn;
	}
	
	@PostMapping(value = "/user/new")
	public User newUser(@RequestBody User user)
	{
		User newUser = userRepository.save(user);
		
		String r1 = "0. Initial Deposit - $" + newUser.getCash() + " on " + new Date();
		
		Recent recent = new Recent(newUser.getUserId(), 1, r1, "---", "---", "---", "---");
		
		recentRepository.save(recent);
		
		return newUser;
	}
}
