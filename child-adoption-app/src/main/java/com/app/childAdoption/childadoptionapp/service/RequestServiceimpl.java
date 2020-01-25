package com.app.childAdoption.childadoptionapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.RequestDao;
import com.app.childAdoption.childadoptionapp.pojos.Ngo;
import com.app.childAdoption.childadoptionapp.pojos.Parent;
import com.app.childAdoption.childadoptionapp.pojos.Request;

@Service
@Transactional
public class RequestServiceimpl implements IRequestService {

	@Autowired
	RequestDao dao;
	
	@PersistenceContext
	EntityManager mgr;
	
	@Override
	public List<Request> listOfRequests() {
		
		String jpql = "select u from Request u";
		
		 return mgr.unwrap(Session.class).createQuery(jpql, Request.class).getResultList();
	}
	
	public List<Request> listOfRequests(Parent parent){
		
		String jpql = "select u from Request u where u.parent = :parent ";
		
		return mgr.unwrap(Session.class).createQuery(jpql, Request.class).setParameter("parent", parent.getReg_No()).getResultList();
		
	}
	
	public List<Request> listOfRequests(Ngo ngo){
		
		String jpql = "select u from ngo u where u.ngo = :ngo";
		
		return mgr.unwrap(Session.class).createQuery(jpql, Request.class).setParameter("ngo", ngo.getNgo_id()).getResultList();
	}
}
