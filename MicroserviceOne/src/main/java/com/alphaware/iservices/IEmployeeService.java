package com.alphaware.iservices;

import java.util.List;

import com.alphaware.entities.Employee;
import com.alphaware.exceptions.RecordAlreadyExistException;
import com.alphaware.exceptions.RecordNotFoundException;

public interface IEmployeeService {
	public Employee addEmployee(Employee employee) throws RecordAlreadyExistException;

	public Employee get(String id)throws RecordNotFoundException;;

	public List<Employee> get();

	public Employee update(String id, Employee employee)throws RecordNotFoundException;

	public String delete(String id) throws RecordNotFoundException;
}
