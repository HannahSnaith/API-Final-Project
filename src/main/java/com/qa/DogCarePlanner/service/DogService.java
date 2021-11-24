package com.qa.DogCarePlanner.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public void addDog(Dog dog) {
        repo.save(dog);
    }

    public List<Dog> readAll() {
    	  return repo.findAll();
    }

    public List<Dog> findByName(String name) {
    	return readAll().stream()
    			.filter(dog -> dog.getName().equals(name))
    			.collect(Collectors.toList());
    }
    
    public Dog readById(long id) {
    	Optional<Dog> option = repo.findById(id);
    	if(option.isPresent()) {
    		return option.get();
    	}
    	return null;
    }
    	    	    
    public Dog updateDog(Long id, Dog newDog) {
       Optional<Dog> existingOptional = this.repo.findById(id);
        Dog existing = existingOptional.get();

        existing.setId(newDog.getId());
        existing.setAge(newDog.getAge());
        existing.setName(newDog.getName());

        return this.repo.save(existing);
    }
    
    public boolean removeDog(Long id) {
    	  this.repo.deleteById(id);
    	  boolean exists = this.repo.existsById(id);
    	  return !exists;
    }

}

