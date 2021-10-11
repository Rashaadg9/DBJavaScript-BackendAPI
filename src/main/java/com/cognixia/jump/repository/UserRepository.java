package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	User getUserByuserId(Integer userId);
	
	@Query(value = "select * from User u where u.username = ?1 AND u.p_password = ?2", nativeQuery = true)
	User findByUsernameAndPassword(String username, String password);
	
	User getUserByUsername(String username);
	
	@Query(value = "select Count(u.username) from User u where u.username = ?1", nativeQuery = true)
	Integer userCheck(String username);
}
