package com.demo.emp.registerController;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.emp.registerRepo.RegisterRepo;
import com.demo.emp.registermodel.Register;

@RestController
@CrossOrigin("http://localhost:3000")
public class RegisterController {
	
	@Autowired
	private RegisterRepo repo;
	
	@PostMapping("/register")
	public Register postRegUser(@RequestBody Register reguser) {
		return repo.save(reguser);
	}
	
	@GetMapping("/login/{email}/{pass}")
	public String getResponse(@PathVariable("email") String email , @PathVariable("pass") String pass) {
		List<Register> temp=repo.findByEmail(email); 
		if(temp.size()==0) return "Enter a valid mail";
		List<Register> arr=repo.findByEmailAndPassword(email, pass);
		if(arr.size()==0) return "Enter valid password";
		else return "Login successful";
	}

}
