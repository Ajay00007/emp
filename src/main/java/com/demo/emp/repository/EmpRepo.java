package com.demo.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.emp.model.Emp;

public interface EmpRepo extends JpaRepository<Emp, Long> {

}
