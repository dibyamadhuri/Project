package com.codedecode.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.exception.BusinessException;
import com.codedecode.demo.exception.ControllerException;
import com.codedecode.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		System.out.println("all Get mapping");
		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<?> getEmpById(@PathVariable("empid") String empidL){
		Long empLong=null;
		try{
			 empLong = Long.parseLong(empidL);
		}catch(NumberFormatException ne){
			ControllerException cException=new ControllerException("602","Send a Number instead of string ");
			return  new ResponseEntity<ControllerException>(cException,HttpStatus.BAD_REQUEST);
		}
		try{
			Employee empRetrieved = employeeServiceInterface.getEmpById(empLong);
			//System.out.println(empRetrieved);	
			return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);
		}catch(BusinessException e){
			ControllerException cException=new ControllerException(e.getErrCode(), e.getErrMessage());
			return new ResponseEntity<ControllerException>(cException,HttpStatus.BAD_REQUEST);			
		}catch(Exception e){
			ControllerException cException=new ControllerException("612", "something went wrong in service layer");
			return new ResponseEntity<ControllerException>(cException,HttpStatus.BAD_REQUEST);		
		}
	}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Long empidL){
		
		employeeServiceInterface.deleteEmpById(empidL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}	
}
