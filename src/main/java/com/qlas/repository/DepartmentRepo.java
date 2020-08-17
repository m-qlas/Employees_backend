package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlas.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, String> {

}
