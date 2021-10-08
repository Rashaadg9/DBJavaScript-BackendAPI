package com.cognixia.jump.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Recent;
import com.cognixia.jump.model.RecentUpdate;
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
	
	@PatchMapping(value = "/recent/update")
	public Recent updateRecent(@RequestBody RecentUpdate recentUpdate)
	{
		Recent recent = recentRepository.getRecentByrecentId(recentUpdate.getUserId());
		int count = recent.getCount();
		String r = (count) + ". " + recentUpdate.getType() + " - $" + recentUpdate.getCash() + " on " + new Date();
		
		int count2 = (count % 5) + 1;
		
		String set = "R" + count2;
		
		switch(set)
		{
			case "R1":
				recent.setR1(r);
				recent.setCount(count + 1);
				break;
			case "R2":
				recent.setR2(r);
				recent.setCount(count + 1);
				break;
			case "R3":
				recent.setR3(r);
				recent.setCount(count + 1);
				break;
			case "R4":
				recent.setR4(r);
				recent.setCount(count + 1);
				break;
			case "R5":
				recent.setR5(r);
				recent.setCount(count + 1);
				break;
			default:
				System.out.println("ERROR");
				break;
		
		}
		return recentRepository.save(recent);
	}
}
