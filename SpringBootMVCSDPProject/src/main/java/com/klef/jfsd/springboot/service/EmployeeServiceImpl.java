package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String EmployeeRegistration(Employee e)
	{
		
		employeeRepository.save(e);
		return "employee registered successfully";
		
	}

	@Override
	public Employee checkemplogin(String email, String pwd) 
	{
		return employeeRepository.checkemplogin(email, pwd);
	}

	@Override
	public Employee displayEmployeeById(int eid) {
		
		return employeeRepository.findById(eid).get();
	}

	@Override
	public String updateEmployeeProfile(Employee emp) {
		
		Employee e = employeeRepository.findById(emp.getId()).get();
	    
	    e.setContact(emp.getContact());
	    e.setDateofbirth(emp.getDateofbirth());
	    e.setDepartment(emp.getDepartment());
	    e.setGender(emp.getGender());
	    e.setLocation(emp.getLocation());
	    e.setName(emp.getName());
	    e.setPassword(emp.getPassword());
	    e.setSalary(emp.getSalary());
	    
	    employeeRepository.save(e);
	    
	    return "Employee Updated Successfully";
	}

	@Override
	public List<Employee> displayEmployeeByDepartment(String department) {
		return employeeRepository.findByDepartment(department);
		
	}

	
	

}
