package com.app.childAdoption.childadoptionapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.NgoDao;

import com.app.childAdoption.childadoptionapp.pojos.Ngo;

@Service
public class NgoLoginServiceImpl implements NgoLoginService{

	@Autowired
	NgoDao dao;
	

	@Override
	public Ngo auth(Ngo ngo) {
		// TODO Auto-generated method stub
		
		Ngo temp = new Ngo();
		temp.setEmail(ngo.getEmail());
		temp.setPassword(ngo.getPassword());
		
		org.springframework.data.domain.Example<Ngo> exampleNgo = org.springframework.data.domain.Example.of(temp);
		
		Optional<Ngo> optional = dao.findOne(exampleNgo);
		if(optional.isPresent())
		{
			return optional.get();
			
		}
		
		return null;
}


	@Override
	public boolean register(Ngo ngo) {
		if(dao.save(ngo) != null)
		{
			return true;
		}
		return false;
	}
	
}
