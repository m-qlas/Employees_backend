package com.qlas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlas.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>
{
//	@Query("SELECT a.id, a.name, a.tech, b.name as Manager\n" + 
//			"FROM employee a, employee b\n" + 
//			"WHERE a.manager_id = b.id")
//	List<Employee> getEmployees();

}
