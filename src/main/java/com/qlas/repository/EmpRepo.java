package com.qlas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlas.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>
{
//	@Query(
//			value = "SELECT a.id, a.first_name, a.last_name, a.department, b.first_name FROM employee a, employee b WHERE a.manager_id = b.id", 
//			nativeQuery = true
//		)
//	public List<String> getEmps();
	
	
	@Query(value = "select e, d from Employee e join e.department d")
	public List<Object> getEmps();
	
	public List<Employee> findById(int id);
	
	public List<Employee> findByFirstName(String fName);
	
	public List<Employee> findByLastName(String lName);
	
	@Query(value = "select e from Employee e join e.department d WHERE d.name=?1")
	public List<Employee> findByDept(String dept);
	
	@Query(value = "select e from Employee e join e.eDetails ed WHERE ed.role=?1")
	public List<Employee> findByRole(String role);
}
