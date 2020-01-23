package com.app.childAdoption.childadoptionapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;

public interface NgoLoginService {
	
	public Ngo auth(Ngo ngo);
	
	public boolean register(Ngo ngo);
	
	public Ngo ngoDeatils(Ngo ngo);
	
	public List<Child> listChildren(Ngo ngo);


}
