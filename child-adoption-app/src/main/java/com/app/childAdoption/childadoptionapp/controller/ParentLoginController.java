package com.app.childAdoption.childadoptionapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.childAdoption.childadoptionapp.pojos.Parent;

import com.app.childAdoption.childadoptionapp.service.ParentLoginServices;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ParentLoginController {

	@Autowired
	ParentLoginServices service;
	
	@RequestMapping(value = "/reg",method = RequestMethod.POST)
	public ResponseEntity<?>m2(@RequestBody Parent parent)
	{

		
		if(service.register(parent))
		{
			return new ResponseEntity<Parent>(parent,HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("Register failed:invalid credits",HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/auth",method = RequestMethod.POST)
	public ResponseEntity<?>m1(@RequestBody Parent parent)
	{

		
		Parent temp = service.auth(parent);
		if(temp!=null)
		{
			return new ResponseEntity<Parent>(parent,HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("Auth failed:invalid credits",HttpStatus.OK);
		
	}
	
	
}