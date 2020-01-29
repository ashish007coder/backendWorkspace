package com.app.childAdoption.childadoptionapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Parent;
import com.app.childAdoption.childadoptionapp.pojos.Request;



public interface ParentServices {
	
	
	public Parent auth(Parent parent);
	
	public boolean register(Parent parent);
	
	public List<Child> getChildListOnRequest(Child child); 
	
	public Parent getparentDetails(Parent parent);
	
	
	
}
