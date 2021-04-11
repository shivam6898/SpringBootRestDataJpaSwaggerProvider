package com.app.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//get all employee by firstname
	List<Employee> findByempFirstname(String empFirstName);
	
	List<Employee> findByEmpLastnameAndEmpFirstname(String empLastname,String empFirstName );
	
	List<Employee> findByEmpLastnameOrEmpFirstname(String empLastname,String empFirstName );
	
	List<Employee> findByempFirstnameIs(String empFirstName);

}
