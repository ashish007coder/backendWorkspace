package com.app.childAdoption.childadoptionapp.service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.ChildDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;


@Service
@Transactional
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
	public boolean register(Child c,int id) {
		
		System.out.println(id);
		String jpql = "select n from Ngo n where n.ngo_id=:nm";
		Ngo n = mgr.unwrap(Session.class).createQuery(jpql, Ngo.class).setParameter("nm",id).getSingleResult();
		System.out.println(c);
		mgr.persist(c);
		n.addChild(c);
		System.out.println(n);
		mgr.merge(c);
		return true;
	}
	

}
