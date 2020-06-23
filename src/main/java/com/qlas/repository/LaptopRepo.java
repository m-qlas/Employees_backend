package com.qlas.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.qlas.model.Employee;
import com.qlas.model.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Laptop l SET l.employee =  ?1 WHERE l.lId = ?2")
	public void changeLaptopOwner(Employee emp, Integer lId);

}
