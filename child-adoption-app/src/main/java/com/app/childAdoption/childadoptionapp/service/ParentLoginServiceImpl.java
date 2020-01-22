package com.app.childAdoption.childadoptionapp.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.ParentDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;
import com.app.childAdoption.childadoptionapp.pojos.Parent;


@Service
public class ParentLoginServiceImpl implements ParentLoginServices{
	
	@Autowired
	ParentDao dao;
	
	@PersistenceContext
	EntityManager mgr;
	
	 @Override 
	 public Parent auth(Parent parent) {
	   String jpql = "select u from Parent u where u.email=:email and u.password=:pass";
	  return mgr.unwrap(Session.class).createQuery(jpql,Parent.class).setParameter("email", parent.getEmail()).setParameter("pass", parent.getPassword()).getSingleResult();
	  
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





}
