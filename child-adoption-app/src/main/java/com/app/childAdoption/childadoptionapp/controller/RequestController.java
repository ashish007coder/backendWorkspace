package com.app.childAdoption.childadoptionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.childAdoption.childadoptionapp.pojos.Ngo;
import com.app.childAdoption.childadoptionapp.pojos.Parent;
import com.app.childAdoption.childadoptionapp.pojos.Request;
import com.app.childAdoption.childadoptionapp.service.RequestServiceimpl;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class RequestController {

	@Autowired
	RequestServiceimpl service;
	
	@RequestMapping(value = "/requestlist",method = RequestMethod.POST)
	public List<Request> requests()
	{
		return service.listOfRequests();
	}
	
	@RequestMapping(value = "/requestlist",method = RequestMethod.POST,params = {"ngo"})
	public List<Request> requests(Ngo ngo)
	{
		return service.listOfRequests(ngo);
	}
	@RequestMapping(value = "/requestlist",method = RequestMethod.POST,params = {"parent"})
	public List<Request> requests(Parent parent)
	{
		return service.listOfRequests(parent);
	}
	
	
	@RequestMapping(value = "/reqcirtainchildtongo",method = RequestMethod.GET)
	public ResponseEntity<?>m2(@RequestBody Request requestparams)
	{
		
		
		System.out.println(requestparams);

		if(service.regForCirtainChild(requestparams))
		{
			return new ResponseEntity<String>("child request sent successfully",HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("Data Fetch failed",HttpStatus.NOT_FOUND);
		
	}
}
