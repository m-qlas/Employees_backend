package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qlas.model.Department;
import com.qlas.model.Manager;

public interface DepartmentRepo extends JpaRepository<Department, String> {

	

}
