package com.demo.emp.registerRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.emp.registermodel.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Long> {

	
List<Register> findByEmailAndPassword(String email,String password);
	
	List<Register> findByEmail(String email);
}
