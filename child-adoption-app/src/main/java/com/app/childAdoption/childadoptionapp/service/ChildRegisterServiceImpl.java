package com.app.childAdoption.childadoptionapp.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.ChildDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;


@Service
public class ChildRegisterServiceImpl implements ChildRegisterService {
	@Autowired
	ChildDao dao; 
	
	@PersistenceContext
	EntityManager mgr;
	
	/*public boolean register(Child child) {
		if(dao.save(child) != null)
		{
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public boolean register(Child c,Ngo ngo) {
		
//		   String jpql = "select u from Parent u where u.email=:email and u.password=:pass";
//			  return mgr.unwrap(Session.class).createQuery(jpql,Ngo.class).setParameter("email", ngo.getEmail()).setParameter("pass", ngo.getPassword()).getSingleResult();
		
		String jpql = "select n from Ngo n where n.ngoName=:nm";
		System.out.println(ngo.getNgoName());
		Ngo n = mgr.unwrap(Session.class).createQuery(jpql, Ngo.class).setParameter("nm", "abc").getSingleResult();
		n.addChild(c);
		if(dao.save(c) != null)
		{
			return true;
		}
		return false;
	}
	

}
