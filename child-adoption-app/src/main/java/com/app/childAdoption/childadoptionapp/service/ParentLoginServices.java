package com.app.childAdoption.childadoptionapp.service;

import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Parent;



public interface ParentLoginServices {
	
	
	public Parent auth(Parent parent);
	
	public boolean register(Parent parent);

}
