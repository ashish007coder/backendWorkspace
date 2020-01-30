package com.app.childAdoption.childadoptionapp.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.NgoDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;

@Service
@Transactional
public class NgoServiceImpl implements NgoService{

	@Autowired
	NgoDao dao;
	
	@PersistenceContext
	EntityManager mgr;



	@Override
	public boolean register(Ngo ngo) {
		if(dao.save(ngo) != null)
		{
			return true;
		}
		return false;
	}


	
	
	
	
	 @Override 
	 public Ngo auth(Ngo ngo) {
		 
	   String jpql = "select u from Ngo u where u.email=:email and u.password=:pass";
	  return mgr.unwrap(Session.class).createQuery(jpql,Ngo.class).setParameter("email", ngo.getEmail()).setParameter("pass", ngo.getPassword()).getSingleResult();
	  
	 }
	 
		@Override
		public Ngo ngoDeatils(Ngo ngo) {
			String jpql = "select u from Ngo u where u.ngo_id=:ngo_id";
			int nid = ngo.getNgo_id();
			return mgr.unwrap(Session.class).createQuery(jpql, Ngo.class).setParameter("ngo_id", nid).getSingleResult();
		}
		@Override
		public List<Child> listChildren(Ngo ngo) {
			List<Child> l1=null;
			String jpql = "select u from Ngo u where u.ngo_id=:ngo_id";
			Ngo n = mgr.unwrap(Session.class).createQuery(jpql, Ngo.class).setParameter("ngo_id",ngo.getNgo_id()).getSingleResult();
			System.out.println(n);
			System.out.println("-------");
			l1=n.getListOfchildren();
			return l1;
		}

		@Override
		public boolean update(Ngo ngo) {
			System.out.println(ngo.getNgo_id());
			if(dao.existsById(ngo.getNgo_id())) {
				Ngo n = (Ngo) mgr.unwrap(Session.class).load(Ngo.class, ngo.getNgo_id());
				n=ngo;
				mgr.unwrap(Session.class).update(n);
			return true;
			}
			return false;
		}
		@Override
		public boolean deleteNgo(int ngo_id) {
			if(dao.existsById(ngo_id)) {
			dao.deleteById(ngo_id);
			return true;
			}
			return false;
		}
		
}
