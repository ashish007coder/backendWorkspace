package com.app.childAdoption.childadoptionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Message;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;
import com.app.childAdoption.childadoptionapp.service.NgoService;

import ch.qos.logback.core.db.dialect.MsSQLDialect;


@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping
public class NgoLoginController {

	@Autowired
	NgoService service;
	
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

		if(temp!=null)
		{
			return new ResponseEntity<Ngo>(temp,HttpStatus.OK);
			
		}

		return new ResponseEntity<String>("Auth failed:invalid credentials",HttpStatus.NOT_FOUND);
		
	}
	
	
	@RequestMapping(value = "/ngodetails",method = RequestMethod.POST)
	public Ngo listStrin(@RequestBody Ngo ngo)
	{
		return service.ngoDeatils(ngo);		
	}
	@RequestMapping(value = "/childlist",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Child> list(@RequestBody Ngo ngo)
	{
		return service.listChildren(ngo);
	}
	@DeleteMapping("/delete/{ngo_id}")
	public ResponseEntity<?> deleteNgo(@PathVariable int ngo_id){
		
		
		if(service.deleteNgo(ngo_id)) {
		Message msg = new Message("Ngo account has been removed");
		return new ResponseEntity<Message>(msg,HttpStatus.OK);}
		Message msg = new Message("Ngo account cant be removed");
		return new ResponseEntity<Message>(msg,HttpStatus.OK);
	}
	@PutMapping(value = "/update")
	public ResponseEntity<?> updateNgo(@RequestBody Ngo ngo){
		ngo = service.auth(ngo);
		if(service.update(ngo)){
			Message msg = new Message("Profile updated sucessfully......");
			return new ResponseEntity<Message>(msg,HttpStatus.OK);
		}
	Message msg = new Message("Cant be updated ");
	return new ResponseEntity<Message>(msg,HttpStatus.OK);
}
}