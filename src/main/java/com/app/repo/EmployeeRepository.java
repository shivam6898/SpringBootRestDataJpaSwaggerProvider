package com.app.repo;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//get all employee by firstname
	List<Employee> findByempFirstname(String empFirstName);
	
	List<Employee> findByEmpLastnameAndEmpFirstname(String empLastname,String empFirstName );
	
	List<Employee> findByEmpLastnameOrEmpFirstname(String empLastname,String empFirstName );
	
	List<Employee> findByempFirstnameIs(String empFirstName);
	
	List<Employee> findByempFirstnameEquals(String empFirstname);
	
	//Between
	List<Employee> findByCreatedAtBetween(Date createdFrom,Date createdTo);
	
	//LessThan
	List<Employee> findByAgeLessThan(Integer age);
	
	//LessThanEqual
	
	//GreaterThan
	
	//GreaterThanEqual
	
	//After
	List<Employee> findByStartedAfter(Integer startedAfter);
	
	//Before
	
	//findByAgeIsNull
	
	//NotNull
	List<Employee> findByAgeIsNotNull();
	
	//findByFirstnameLike
	
	//findByFirstnameNotLike
	
	//findByFirstnameStartingWith
	
	//findByFirstnameEndingWith
	
	//findByFirstnameContaining
	
	//List<Employee> findByAgeOrderByEmpLastnameDes(Integer age);
	
	//findByLastnameNot
	
	//findByAgeIn(Collection<Age> ages)
	
	//findByAgeNotIn(Collection<Age> ages) 
	
	public List<Employee> findByActiveTrue();
	
	
	  @Query(value = "select * from employee where email = ?1", nativeQuery = true)
	 public Employee findByemail(String emailAddress);
	  
	  
	
	  
}
