package com.qa.DogCarePlanner.service;

import java.util.List;
import java.util.Optional;
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
	
	public ShoppingList addItem(ShoppingList item) {
		  return this.repo.save(item);
    }

    public List<ShoppingList> readAll() {
    	  return repo.findAll();
    }
    
    public ShoppingList readById(Long id) {
        Optional<ShoppingList> ShoppingList = this.repo.findById(id);
        return ShoppingList.get();
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

