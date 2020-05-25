package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlas.model.*;

public interface SalaryRepo extends JpaRepository<Salary, Integer> 
{

}
