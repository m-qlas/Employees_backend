package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlas.model.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

}
