package com.demoapp.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.model.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> 
{

	
}
