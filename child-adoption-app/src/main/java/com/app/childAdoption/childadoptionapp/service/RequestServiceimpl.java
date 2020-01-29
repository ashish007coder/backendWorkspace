package com.app.childAdoption.childadoptionapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.RequestDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;
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
		
		System.out.println(parent.getReg_No());
//		String jpql = "select u from Request u ,Ngo n where n.ngo_id= :ngo";
		String jpql ="SELECT r FROM Request r JOIN r.parent u WHERE u.reg_No=:parent";
		return mgr.unwrap(Session.class).createQuery(jpql, Request.class).setParameter("parent",parent.getReg_No()).getResultList();
		
	}
	
	public List<Request> listOfRequests(Ngo ngo){
		
		System.out.println(ngo.getNgo_id());
//		String jpql = "select u from Request u ,Ngo n where n.ngo_id= :ngo";
		String jpql ="SELECT r FROM Request r JOIN r.ngo u WHERE u.ngo_id=:ngo";
		return mgr.unwrap(Session.class).createQuery(jpql, Request.class).setParameter("ngo",ngo.getNgo_id()).getResultList();
	}

	@Override
	public boolean regForCirtainChild(Request requestparams) {
		// TODO Auto-generated method stub
		System.out.println(requestparams);
		if(dao.save(requestparams) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public Request detailsOfOneChild(int id) {
		// TODO Auto-generated method stub
		String jpql = "select u from Request u where u.req_id=:reqid";

		
		 Request reqresult = mgr.unwrap(Session.class).createQuery(jpql, Request.class).setParameter("reqid",id).getSingleResult();
		 
		
		 return reqresult;
	}
}
