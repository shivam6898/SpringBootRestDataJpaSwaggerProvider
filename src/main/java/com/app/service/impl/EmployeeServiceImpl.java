package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	//to perfom db operation 
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public Integer saveEmployee(Employee e) {
		return employeeRepository.save(e).getEmpId();
	}


	@Override
	@Transactional public void updateEmployee(Employee e) {
		employeeRepository.save(e);
		}

	@Override
	@Transactional
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Optional<Employee> getOneEmployee(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean isPresent(Integer id) {
		return employeeRepository.existsById(id);
	}



}
