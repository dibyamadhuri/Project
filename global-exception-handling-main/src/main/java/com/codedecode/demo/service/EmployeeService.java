package com.codedecode.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.exception.BusinessException;
import com.codedecode.demo.repos.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getName().isEmpty() || employee.getName().length()==0){
			throw new BusinessException("601","Please send proper name,It blank");
		}
		try{
		   Employee savedEmployee = crudRepo.save(employee);
		   return savedEmployee;
		}catch(IllegalArgumentException e){
			throw new BusinessException("602","employee is null"+e.getMessage());
		}catch(Exception e){
			throw new BusinessException("603", "something went wrong in service layer");
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidL) {
		try{
		   return crudRepo.findById(empidL).get();
		}catch(IllegalArgumentException e){
			throw new BusinessException("606","employee id is null");
	    }catch(NoSuchElementException e){
		    throw new BusinessException("603", "given employee Id is not present in Database ");
	    }
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}

}
