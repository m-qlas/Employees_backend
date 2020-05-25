package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlas.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>
{

}
