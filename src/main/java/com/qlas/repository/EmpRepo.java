package com.qlas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlas.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>
{
	@Query("SELECT a.manager FROM Employee a, Employee b WHERE a.manager = b.id")
	List<String> getEmps();
}
