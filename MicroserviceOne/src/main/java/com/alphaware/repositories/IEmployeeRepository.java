package com.alphaware.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alphaware.entities.Employee;

@Repository
public interface IEmployeeRepository extends MongoRepository<Employee, String> {

}
