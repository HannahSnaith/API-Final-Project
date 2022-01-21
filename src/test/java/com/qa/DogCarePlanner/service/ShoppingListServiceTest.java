package com.qa.DogCarePlanner.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.DogCarePlanner.entities.ShoppingList;
import com.qa.DogCarePlanner.repo.ShoppingListRepo;



public class ShoppingListServiceTest {
	 
	@Autowired
	    private ShoppingListService service;

	    @MockBean
	    private ShoppingListRepo repo;
	    
	    @Test
	    void testaddItem() {
	    	final ShoppingList TEST_ITEM = new ShoppingList(0, "Dog food", 15);
	        final ShoppingList TEST_SAVED_ITEM = new ShoppingList(1L, "Dog food", 15);

	        Mockito.when(repo.save(TEST_ITEM)).thenReturn(TEST_SAVED_ITEM);
	        
	        assertThat(this.service.addItem(TEST_ITEM)).isEqualTo(TEST_SAVED_ITEM);
	        
	        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_ITEM);
	    }
	    
	    @Test
	    void testreadAll() {
	    	final ShoppingList ITEM1 = new ShoppingList(1L, "Dog food", 15);
	        final ShoppingList ITEM2 = new ShoppingList(2L, "Ball", 3);
	   
	    	List<ShoppingList> items = new ArrayList<>();
	    	items.add(ITEM1);
	    	items.add(ITEM2);
	    	
	    	Mockito.when(repo.findAll()).thenReturn(items);
	    	
	    	assertThat(this.service.readAll()).isEqualTo(items);
	    	
	    	Mockito.verify(this.repo, Mockito.times(1)).findAll();
	    	
	    }
	    
	    @Test
	    void testreadById() {
	    	 Long id = 1L;
	         ShoppingList expected = new ShoppingList(id, "Toby", 10);
	    	
	         Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));
	    	
	         assertThat(this.service.readById(id)).isEqualTo(expected);
	         
	         Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	    }
	    
	    @Test
	    void testupdateShoppingList() {
//	    	Long id = 1L;
//	        ShoppingList newValues = new ShoppingList(id, "Dog food", 15);
//	        ShoppingList existing = new ShoppingList(id, "Ball", 3);
//	        ShoppingList updated = new ShoppingList(newValues.getId(), newValues.getItem(), newValues.getPrice());
//	        
//	        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
//	        Mockito.when(this.repo.save(updated)).thenReturn(updated);
//	        
//	        assertThat(this.service.updateShoppingList(id, newValues)).isEqualTo(updated);
//	        
//	        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//	        Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	    }
	    
	    @Test
	    void testremoveItem() {
	        Long id = 1L;
	       
	        Mockito.when(this.repo.existsById(id)).thenReturn(false);
	    
	        assertThat(this.service.removeItem(id)).isTrue();

	        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	    }
}
