package com.qa.DogCarePlanner.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.DogCarePlanner.entities.ShoppingList;

@Repository
public interface ShoppingListRepo extends JpaRepository<ShoppingList, Long> {

}
