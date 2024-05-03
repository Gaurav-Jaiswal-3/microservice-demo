package com.alphaware.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Employee")
public class Employee {
	@Id
	private String id;
	private String name;
	private String address;
	private String designation;
}