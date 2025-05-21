package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Employee;

import jakarta.transaction.Transactional;

import java.util.List;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
	@Query("select e from Employee e where e.email=?1 and e.password=?2")
	public Employee checkemplogin(String emial,String pwd);
	
	@Query("update Employee e set e.status=?1 where e.id=?2")
	@Modifying // DML
	@Transactional // to auto commit 
	public int updateempstatus(String estatus ,int eid);
	
	// no need to write queries explicitly  
	public List<Employee> findByDepartment(String department);
	public List<Employee> findByDepartmentAndGender(String department, String gender);
	
}
