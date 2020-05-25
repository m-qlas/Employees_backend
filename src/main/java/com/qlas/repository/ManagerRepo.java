package com.qlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlas.model.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
