package com.app.childAdoption.childadoptionapp.service;

import java.util.List;

import com.app.childAdoption.childadoptionapp.pojos.Child;
import com.app.childAdoption.childadoptionapp.pojos.Parent;
import com.app.childAdoption.childadoptionapp.pojos.Request;

public interface IRequestService {

	
		public List<Request> listOfRequests();
		
		public boolean regForCirtainChild(Request requestparams);
		
		public Request detailsOfOneChild(int id);

}
