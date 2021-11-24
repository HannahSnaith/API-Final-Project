package com.qa.DogCarePlanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.DogCarePlanner.entities.ShoppingList;
import com.qa.DogCarePlanner.service.ShoppingListService;


@RestController
public class ShoppingListController {
	private ShoppingListService service;
	 
 	@Autowired
    public ShoppingListController(ShoppingListService service) {
        super();
        this.service = service;
    }

 	@PostMapping("/createListItem")
    public String create(@RequestBody ShoppingList item) {
    	service.addItem(item);
        return "Item Added";
    }
    
    @GetMapping("/readShoppingListById/{id}")
    public ShoppingList readById(@PathVariable long id) {
        return service.readById(id);
    }

    @PostMapping("/updateItem/{id}")
    public String update(@PathVariable long id, @RequestBody ShoppingList item) {
        service.removeItem(id);
        item.setId(id);
        service.addItem(item);
        return "Item updated";
    }

    @DeleteMapping("/deleteItem/{id}") 
    public boolean removeItem(@PathVariable long id) {
        service.removeItem(id);
    	return true;
    }
    
    @GetMapping("/readAllShoppingList")
    public List<ShoppingList> read()  {
    	return service.readAll();
    }
    

}


