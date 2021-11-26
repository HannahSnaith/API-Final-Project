package com.qa.DogCarePlanner.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.DogCarePlanner.entities.Dog;
import com.qa.DogCarePlanner.service.DogService;

@RestController
public class DogController {
	
	private DogService service;
	
	@Autowired
	 public DogController(DogService service) {
        super();
        this.service = service;
    }

    @PostMapping("/createDog")
    public String createDog(@RequestBody Dog dog) {
    	service.addDog(dog);
        return "Dog Added";
    }

    @GetMapping("/readDogById/{id}")
    public Dog readById(@PathVariable long id) {
        return service.readById(id);
    }

    @PostMapping("/updateDog/{id}")
    public String updateDog(@PathVariable long id, @RequestBody Dog dog) {
        service.removeDog(id);
        dog.setId(id);
        service.addDog(dog);
        return "Dog updated";
    }

    @DeleteMapping("/deleteDog/{id}") 
    public boolean removeDog(@PathVariable long id) {
        service.removeDog(id);
    	return true;
    }
    
    @GetMapping("/readAllDogs")
    public List<Dog> readAll()  {
    	return service.readAll();
    }
}