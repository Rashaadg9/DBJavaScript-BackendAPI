package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Recent;

@Repository
public interface RecentRepository extends JpaRepository<Recent, Integer>
{
	Recent getRecentByrecentId(Integer recentId);
}
