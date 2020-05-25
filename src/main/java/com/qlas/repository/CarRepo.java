package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlas.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
