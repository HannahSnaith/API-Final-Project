package com.qa.DogCarePlanner.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.DogCarePlanner.entities.Dog;
import com.qa.DogCarePlanner.repo.DogRepo;

@SpringBootTest
public class DogServiceTest {

    @Autowired
    private DogService service;

    @MockBean
    private DogRepo repo;

    @Test
    void testaddDog() {
        final Dog TEST_DOG = new Dog(0, "Toby", 10);
        final Dog TEST_SAVED_DOG = new Dog(1L, "Toby", 10);


        Mockito.when(repo.save(TEST_DOG)).thenReturn(TEST_SAVED_DOG);

       
        assertThat(this.service.addDog(TEST_DOG)).isEqualTo(TEST_SAVED_DOG);

        
        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_DOG);
    }

    @Test
    void testreadAll() {
    	final Dog DOG1 = new Dog(1L, "Toby", 10);
        final Dog DOG2 = new Dog(2L, "Bella", 3);
   
    	List<Dog> dogs = new ArrayList<>();
    	dogs.add(DOG1);
    	dogs.add(DOG2);
    	
    	Mockito.when(repo.findAll()).thenReturn(dogs);
    	
    	assertThat(this.service.readAll()).isEqualTo(dogs);
    	
    	Mockito.verify(this.repo, Mockito.times(1)).findAll();
    	
    }
    
    @Test
    void testreadById() {
    	 Long id = 1L;
         Dog expected = new Dog(id, "Toby", 10);
    	
         Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));
    	
         assertThat(this.service.readById(id)).isEqualTo(expected);
         
         Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    	
    	
    }
    
    @Test
    void testupdateDog() {
//    	Long id = 1L;
//        Dog newValues = new Dog(id, "Bella", 3);
//        Dog existing = new Dog(id, "Toby", 10);
//        Dog updated = new Dog(newValues.getId(), newValues.getName(), newValues.getAge());
//        
//        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
//        Mockito.when(this.repo.save(updated)).thenReturn(updated);
//        
//        assertThat(this.service.updateDog(id, newValues)).isEqualTo(updated);
//        
//        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//        Mockito.verify(this.repo, Mockito.times(1)).save(updated);
    }
    
    @Test
    void testremoveDog() {
        Long id = 1L;
       
        Mockito.when(this.repo.existsById(id)).thenReturn(false);
    
        assertThat(this.service.removeDog(id)).isTrue();

        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
    }
}

// GIVEN

// WHEN

// THEN

// verify
