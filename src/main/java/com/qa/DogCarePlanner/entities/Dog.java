package com.qa.DogCarePlanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Standard auto increment for SQL
	private long id;
	
	@Column
	private String name;
	
	@Column
	private int age;

	public Dog(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Dog() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}

