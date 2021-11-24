package com.qa.DogCarePlanner.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.DogCarePlanner.entities.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Long> {

}

