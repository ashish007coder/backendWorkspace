package com.app.childAdoption.childadoptionapp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.ParentDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Parent;


@Service
public class ParentLoginServiceImpl implements ParentLoginServices{
	
	@Autowired
	ParentDao dao;
	

	@Override
	public Parent auth(Parent parent) {
		// TODO Auto-generated method stub
		
		Parent temp = new Parent();
		temp.setEmail(parent.getEmail());
		temp.setPassword(parent.getPassword());
		
		org.springframework.data.domain.Example<Parent> exampleParent = org.springframework.data.domain.Example.of(temp);
		
		Optional<Parent> optional = dao.findOne(exampleParent);
		if(optional.isPresent())
		{
			return optional.get();
			
		}
		
		return null;
	}


	@Override
	public boolean register(Parent parent) {
		// TODO Auto-generated method stub
		if(dao.save(parent) != null)
		{
			return true;
		}
		return false;
	}


//	@Override
//	public boolean addChild(Child child) {
//		// TODO Auto-generated method stub
//		
//		return false;
//	}


}
