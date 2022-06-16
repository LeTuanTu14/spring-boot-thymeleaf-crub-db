package com.example.demothymeleafcrubdb.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demothymeleafcrubdb.dao.EmployeeRepository;
import com.example.demothymeleafcrubdb.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRespository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRespository) {
		employeeRespository= theEmployeeRespository;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRespository.save(theEmployee);
	}

	@Override
	public Employee getEmployee(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result= employeeRespository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}else {
			throw new RuntimeException("Did not find employee id - "+theId);
		}
		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub
		employeeRespository.deleteById(theId);
	}

}
