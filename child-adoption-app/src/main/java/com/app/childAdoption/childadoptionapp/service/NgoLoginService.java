package com.app.childAdoption.childadoptionapp.service;

import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.pojos.Ngo;

public interface NgoLoginService {
	
	public Ngo auth(Ngo ngo);
	
	public boolean register(Ngo ngo);

}
