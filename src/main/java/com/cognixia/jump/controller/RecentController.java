package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Recent;
import com.cognixia.jump.repository.RecentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RecentController
{
	@Autowired
	private RecentRepository recentRepository;
	
	@GetMapping(value = "/recent")
	public Iterable<Recent> all()
	{
		List<Recent> recent = recentRepository.findAll();
		
		return recent;
	}
	
	@GetMapping(value = "/recent/{recentId}")
	public Recent getRecentById(@PathVariable("recentId") Integer recentId)
	{
		Recent recent = recentRepository.getRecentByrecentId(recentId);
		
		return recent;
	}
}
