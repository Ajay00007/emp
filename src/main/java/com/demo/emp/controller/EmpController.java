package com.demo.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.emp.model.Emp;
import com.demo.emp.repository.EmpRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmpController {

	
	@Autowired
	private EmpRepo repo;
	
	@PostMapping("/addemp")
	public Emp addEmployee(@RequestBody Emp emp) {
		return repo.save(emp);
	}
	
	@GetMapping("/emplist")
	public List<Emp> getAllEmployees(){
		return repo.findAll();
		
	}
	
	@GetMapping("/emp/{id}")
	public Emp getEmployee(@PathVariable Long id) {
		return repo.findById(id).get();
	}
	
	@PutMapping("/editemp/{id}")
	public Emp editEmployee(@RequestBody Emp emp,@PathVariable long id) {
		return repo.save(emp);
	}
	
	@DeleteMapping("/delemp/{id}")
	public void deleteEmployee(@PathVariable long id) {
		repo.deleteById(id);
	}
}
