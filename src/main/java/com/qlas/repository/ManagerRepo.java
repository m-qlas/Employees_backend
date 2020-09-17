package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlas.model.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {

	@Query(value = "select * from employee e where department_name = ?1 and position='M'", nativeQuery = true)
	public Manager findByDept(String deptName);
}
