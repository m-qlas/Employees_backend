package com.qlas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlas.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>
{
	@Query(
			value = "SELECT a.id, a.name, a.tech, b.name FROM employee a, employee b WHERE a.manager_id = b.id", 
			nativeQuery = true
		)
	public List<String> getEmps();
	
	public List<Employee> findByName(String name);

	public List<Employee> findByTech(String tech);
}
