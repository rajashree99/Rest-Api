package com.example.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	UserRepo userepo;
	
	 @GetMapping("/all")
	    public List<UserModel> getUsers() {
	        return userepo.findAll();
	    }
	
	
	 @PostMapping("/load")
	    public UserModel createUser(@RequestBody UserModel user) {
		    System.out.println("working");
	        return userepo.save(user);
	    }
	
     @PutMapping("/{id}")
     public UserModel updateUser(@PathVariable int id,@RequestBody UserModel user)
     {
    	 user.setId(id);
		 return userepo.save(user);
    	 
    	 
     }
     @DeleteMapping("/{id}")
     public void deleteUser(@PathVariable int id)
     {
    	  userepo.deleteById(id);
   }
     
}
