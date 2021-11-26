package com.qa.DogCarePlanner.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.DogCarePlanner.entities.Dog;
import com.qa.DogCarePlanner.repo.DogRepo;

@Service
public class DogService {

	DogRepo repo;
	
	@Autowired   
    public DogService(DogRepo repo) {
		super();
		this.repo = repo;
	}

	public Dog addDog(Dog dog) {
        return repo.save(dog);
    }

    public List<Dog> readAll() {
    	  return repo.findAll();
    }
    	    	    
    public Dog readById(Long id) {
        Optional<Dog> dog = this.repo.findById(id);
        return dog.get();
    }
    
    public Dog updateDog(Long id, Dog newDog) {
       Optional<Dog> existingOptional = this.repo.findById(id);
        Dog existing = existingOptional.get();
        
        existing.setId(newDog.getId());
        existing.setName(newDog.getName());
        existing.setAge(newDog.getAge());
        
        return this.repo.save(existing);
    }
    
    public boolean removeDog(Long id) {
    	  this.repo.deleteById(id);
    	  boolean exists = this.repo.existsById(id);
    	  return !exists;
    }

}

