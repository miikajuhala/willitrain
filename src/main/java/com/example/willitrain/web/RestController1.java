package com.example.willitrain.web;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.nio.charset.StandardCharsets;
import java.rmi.ServerException;
import java.security.Principal;
import java.util.List;





@RestController
@CrossOrigin
public class RestController1 {
	

	
	 
@Autowired
private UserRepository urepository;




//TODO: set restrictions
@GetMapping("/api/getid")
@ResponseBody
public Long getId(@RequestParam(required = true) String id) {
	User cur = urepository.findByUsername(id);
    return cur.getId();
}

@PostMapping(value="/api/register")
public ResponseEntity<User> create(@RequestBody User newUser) throws ServerException {
	
	 String oldpass= newUser.getPassword();
	 String newpass = BCrypt.hashpw(oldpass, BCrypt.gensalt());
	 //varmistetaan että ei pääse huijaamaan ja forcetaan user rooli.
	 newUser.setRole("USER");
	 newUser.setPassword(newpass);
	 System.out.println("HASHATTY PASSWORDI"+newpass);
	   
 
	 User useri = urepository.save(newUser);
	 
		 if (useri == null) {
		     throw new ServerException(null);
		 } else {
		     return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		 }
}

} 