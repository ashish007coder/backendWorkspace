package com.app.childAdoption.childadoptionapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.childAdoption.childadoptionapp.pojos.Ngo;
import com.app.childAdoption.childadoptionapp.service.NgoLoginService;


@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class NgoLoginController {

	@Autowired
	NgoLoginService service;
	
	@RequestMapping(value = "/ngoreg",method = RequestMethod.POST)
	public ResponseEntity<?>m2(@RequestBody Ngo ngo)
	{

		
		if(service.register(ngo))
		{
			return new ResponseEntity<Ngo>(ngo,HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("Register failed:invalid credentials",HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/ngoauth",method = RequestMethod.POST)
	public ResponseEntity<?>m1(@RequestBody Ngo ngo)
	{
		Ngo temp = service.auth(ngo);
		System.out.println("temp "+temp);

		if(temp!=null)
		{
			return new ResponseEntity<Ngo>(temp,HttpStatus.OK);
			
		}

		return new ResponseEntity<String>("Auth failed:invalid credentials",HttpStatus.NOT_FOUND);
		
	}
	
	

	
	
}