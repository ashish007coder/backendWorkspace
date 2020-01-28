package com.app.childAdoption.childadoptionapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;

public interface NgoService {
	
	Ngo auth(Ngo ngo);
	boolean register(Ngo ngo);
	Ngo ngoDeatils(Ngo ngo);
	List<Child> listChildren(Ngo ngo);
	Ngo update(Ngo ngo);
	boolean deleteNgo(int ngo_id);
}
