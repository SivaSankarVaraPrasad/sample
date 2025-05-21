package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CustomerRepository;
import com.klef.jfsd.springboot.repository.EmployeeRepository;


@Service
public class AdminServiceImpl  implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Employee> viewAllEmployees() 
	{
		return employeerepository.findAll();
	}

	@Override
	public Admin checkadminlogin(String uname, String pwd) {
		return adminRepository.checkadminlogin(uname, pwd);
		
	}

	@Override
	public String deleteemp(int eid) {
		
		 employeerepository.deleteById(eid);
		 return "Employee deleted successfully";
	}

	@Override
	public Employee displayempbyId(int eid) {
		
		return employeerepository.findById(eid).get();
	}

	@Override
	public long empcount() {
		
		return employeerepository.count();
	}

	@Override
	public String updateempstatus(String estatus, int eid) {
		int x = employeerepository.updateempstatus(estatus, eid);
		if(x>0) {
			return "Employee status updated successfully";
		}
		
		
		return "id not found";
			
	}

	@Override
	public String addcustomer(Customer c) {
		
		
		customerRepository.save(c);
		
		return "Customer added successfully";
	}

}
