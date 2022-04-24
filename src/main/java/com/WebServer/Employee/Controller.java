package com.WebServer.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServer.Employee.Model.RestUser;

@RestController
@RequestMapping("/users")
public class Controller {
	Map< String,RestUser > allUsers = new HashMap<>();
	
	@GetMapping
	public Collection<RestUser> getmethod()
	{
		return allUsers.values();
	}
	
	@PostMapping
	public String postmethod(@RequestBody RestUser userdetails)
	{
		RestUser addValue =new RestUser();
		addValue.setId(userdetails.getId());
		addValue.setName(userdetails.getName());
		addValue.setSal(userdetails.getSal());
		addValue.setDesignation(userdetails.getDesignation());
		allUsers.put(userdetails.getId(), addValue);
		return "Emp added";
	}
	
	@PutMapping(path="/{userid}")
	public String putmethod(@PathVariable String userId,@RequestBody RestUser userdetails)
	{

		if(allUsers.containsKey(userId)) 
		{	
			RestUser addValue =new RestUser();
			addValue.setId(userdetails.getId());
			addValue.setName(userdetails.getName());
			addValue.setSal(userdetails.getSal());
			addValue.setDesignation(userdetails.getDesignation());
			allUsers.put(userId, addValue);
			return "Emp Updated";		
		}
			else
			{
				return "UserId Not Found,Unable to Upadate";
			}
	}
	
	@DeleteMapping(path="/{userid}")
	public String deletemethod(@PathVariable String userId)
	{
		if(allUsers.containsKey(userId)) 
		{
			
		
		return userId+"UserDeleted";
		}
		else
		{
			return "UserId Not Found";
		}
}
	

}