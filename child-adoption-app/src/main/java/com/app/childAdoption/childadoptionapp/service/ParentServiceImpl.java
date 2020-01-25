package com.app.childAdoption.childadoptionapp.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Null;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.ParentDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Parent;


@Service
public class ParentServiceImpl implements ParentServices{
	
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

	@Override
	public List<Child> getChildListOnRequest(Child child) {
				
		String jpql;
		System.out.println("child "+child);
		
		System.out.println(child);
		jpql = "Select u from Child u where";

		if(child.getGender()!=null&&child.getAge()!=0)
		{
			jpql += " u.gender=:gen and u.age=:ag";
			return mgr.unwrap(Session.class).createQuery(jpql,Child.class).setParameter("gen", child.getGender()).setParameter("ag", child.getAge()).getResultList();

			
		}
		else if(child.getGender()!=null&& child.getAge()==0)
		{
			jpql += " u.gender=:gen";
			return mgr.unwrap(Session.class).createQuery(jpql,Child.class).setParameter("gen", child.getGender()).getResultList();

		}
		else if( (child.getGender()==null&&child.getAge()!=0))
		{
			jpql += " u.age=:ag";
			return mgr.unwrap(Session.class).createQuery(jpql,Child.class).setParameter("ag", child.getAge()).getResultList();

		}
		
		return null;
	}
	

}
