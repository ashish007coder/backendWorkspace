package com.app.childAdoption.childadoptionapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.childAdoption.childadoptionapp.daos.ChildDao;
import com.app.childAdoption.childadoptionapp.pojos.Child;

@Service
public class ChildRegisterServiceImpl implements ChildRegisterService {
	@Autowired
	ChildDao dao;
	@Override
	public boolean register(Child child) {
		if(dao.save(child) != null)
		{
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
