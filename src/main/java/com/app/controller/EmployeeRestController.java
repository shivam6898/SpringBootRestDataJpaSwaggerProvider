package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	
	/*   save employee
	 *   localhost:8081/rest/employee/save   
	 *    { "empName":"testname", "empSal":"100000" }
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveEmployee(employee);
			resp=new ResponseEntity<String>("Employee '"+id+"' created", HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

     //get all employees
	@GetMapping("/getall")
	public ResponseEntity<?>  getAllEmployees(){
		 ResponseEntity<?> resp =null;
		List<Employee> emplist=service.getAllEmployees();
		if(emplist==null && emplist.isEmpty() ) {
			String msg="NO DATA FOUND";
			resp=new ResponseEntity<String>(msg,HttpStatus.NO_CONTENT);
		}else {
			resp=new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);
		}

		return resp;
	}


	
	//3. delete based on id , if exist
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id)
	{
		ResponseEntity<String> resp=null;
		//check for exist
		boolean present=service.isPresent(id);
		if(present) {
			//if exist
			service.deleteEmployee(id);
			resp=new ResponseEntity<String>("Deleted '"+id+"' successfully",HttpStatus.OK);
		} else { //not exist
			resp=new ResponseEntity<String>("'"+id+"' Not Exist",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}



	//4. update data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Employee employee){
		ResponseEntity<String> resp=null;
		//check for id exist
		boolean present=service.isPresent(employee.getEmpId());
		if(present) { //if exist
			service.updateEmployee(employee);
			resp=new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
		} else {
			//not exist
			resp=new ResponseEntity<String>("Record '"+employee.getEmpId()+" ' not found",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	// find employee by first name
	@GetMapping("/getbyfirstname/{empFirstName}")
	  private List<Employee> findByFirstname(@PathVariable String empFirstName){
		List<Employee> emp= employeeRepository.findByempFirstname(empFirstName);
		return emp;
	  }
	
	
	@GetMapping("/getbyfirstnameIs/{empFirstName}")
	  private List<Employee> findByFirstnameIs(@PathVariable String empFirstName){
		List<Employee> emp= employeeRepository.findByempFirstnameIs(empFirstName);
		return emp;
	  }
	 
	
	//find employee by first and lastname 
	@GetMapping("/getbyfirstnameandlastname/{empFirstName}/{empLastname}")
	  private List<Employee> findByFirstnameandlastname(@PathVariable String empLastname ,@PathVariable String empFirstName){
		List<Employee> emp= employeeRepository.findByEmpLastnameAndEmpFirstname(empLastname, empFirstName);
		return emp;
	  }
	
	
	@GetMapping("/getallactive")
	private List<Employee> getAllActiveEmployee() {
		return employeeRepository.findByActiveTrue();
	}
	
	
	@GetMapping("/getbyemail/{email}")
	private  ResponseEntity<String> findEmployeeByEmail(@PathVariable String email) {
		Employee emp=employeeRepository.findByemail(email);
		return new ResponseEntity<String>(emp.toString(),HttpStatus.OK);
	}
	
}
