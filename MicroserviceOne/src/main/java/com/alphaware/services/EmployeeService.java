package com.alphaware.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaware.entities.Employee;
import com.alphaware.exceptions.RecordAlreadyExistException;
import com.alphaware.exceptions.RecordNotFoundException;
import com.alphaware.iservices.IEmployeeService;
import com.alphaware.repositories.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) throws RecordAlreadyExistException {
		if (employeeRepository.existsById(employee.getId())) {
			throw new RecordAlreadyExistException("Employee with ID " + employee.getId() + " already exists");
		} else {
			return employeeRepository.save(employee);
		}
	}

	@Override
	public Employee get(String id) throws RecordNotFoundException {
	    return employeeRepository.findById(id)
	            .orElseThrow(() -> new RecordNotFoundException("Record Not Found with the id: " + id));
	}


	@Override
	public List<Employee> get() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee update(String id, Employee employee) throws RecordNotFoundException {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Record is Not Present with the id: " + id));

		employee.setId(existingEmployee.getId());
		return employeeRepository.save(employee);
	}

	@Override
	public String delete(String id) throws RecordNotFoundException {
		employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Record is Not Present with the id: " + id));
		employeeRepository.deleteById(id);
		return "Record Deleted Successfully";
	}

}
