package com.app.childAdoption.childadoptionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
