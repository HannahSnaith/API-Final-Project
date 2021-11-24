package com.qa.DogCarePlanner.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.DogCarePlanner.entities.ShoppingList;
import com.qa.DogCarePlanner.repo.ShoppingListRepo;

@Service
public class ShoppingListService {

	ShoppingListRepo repo;
	
	@Autowired
	public ShoppingListService(ShoppingListRepo repo) {
		super();
		this.repo = repo;
	}
	
	public void addItem(ShoppingList item) {
        repo.save(item);
    }

    public List<ShoppingList> readAll() {
    	  return repo.findAll();
    }

    public List<ShoppingList> findByItem(String item) {
    	return readAll().stream()
    			.filter(user -> user.getItem().equals(item))
    			.collect(Collectors.toList());
    }
    
    public ShoppingList readById(long id) {
    	Optional<ShoppingList> option = repo.findById(id);
    	if(option.isPresent()) {
    		return option.get();
    	}
    	return null;
    }
    	    	    
    public ShoppingList updateItem(Long id, ShoppingList newItem) {
       Optional<ShoppingList> existingOptional = this.repo.findById(id);
        ShoppingList existing = existingOptional.get();

        existing.setItem(newItem.getItem());
        existing.setPrice(newItem.getPrice());

        return this.repo.save(existing);
    }
    
    public boolean removeItem(Long id) {
    	  this.repo.deleteById(id);
    	  boolean exists = this.repo.existsById(id);
    	  return !exists;
    }

}

