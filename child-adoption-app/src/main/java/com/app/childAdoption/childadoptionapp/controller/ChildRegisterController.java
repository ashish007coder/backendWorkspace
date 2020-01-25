package com.app.childAdoption.childadoptionapp.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;
import com.app.childAdoption.childadoptionapp.service.ChildRegisterService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ChildRegisterController {
	
	@Autowired
	ChildRegisterService service;
	
	@RequestMapping(value = "/childreg",method = RequestMethod.POST)
	public ResponseEntity<?>m2(@Valid @RequestBody Child child,Ngo ngo,@RequestParam(value = "image", required = false) MultipartFile image)
	{
		
		if(image!=null)
		{
			try {
				child.setimageUrl(image.getBytes());
				
				System.out.println("image added successfully!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(service.register(child,ngo))
		{
			return new ResponseEntity<Child>(child,HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("Register failed:invalid credentials",HttpStatus.OK);	
	}
}
