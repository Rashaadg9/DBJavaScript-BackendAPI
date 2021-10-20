package com.cognixia.jump.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Recent;
import com.cognixia.jump.model.TransferForm;
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
	
	@GetMapping(value = "/user/username/{username}")
	public User getUserByUsername(@PathVariable("username") String username)
	{
		User user = userRepository.getUserByUsername(username);
		
		return user;
	}
	
	@GetMapping(value = "/user/check/{username}")
	public int userCheck(@PathVariable("username") String username)
	{
		int i = userRepository.userCheck(username);
		
		return i;
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
	
	@PatchMapping(value = "/user/update")
	public User userUpdate(@RequestBody User user)
	{
		return userRepository.save(user);
	}
	
	@PatchMapping(value = "/user/transfer")
	public User userTransfer(@RequestBody TransferForm transfer)
	{
		User from = userRepository.getUserByuserId(transfer.getFromId());
		User to = userRepository.getUserByUsername(transfer.getToUsername());
		
		from.setCash( from.getCash() - transfer.getFromCash() );
		to.setCash( to.getCash() + transfer.getFromCash() );
		
		userRepository.save(to);
		return userRepository.save(from);
	}
	
	@DeleteMapping(value = "user/delete/{userId}")
	public void userDelete(@PathVariable Integer userId)
	{
		User user = userRepository.getUserByuserId(userId);
		Recent recent = recentRepository.getRecentByrecentId(userId);
		
		userRepository.delete(user);
		recentRepository.delete(recent);
	}
}
