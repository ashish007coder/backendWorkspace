package com.app.childAdoption.childadoptionapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.childAdoption.childadoptionapp.pojos.Child;

public interface ChildDao extends JpaRepository<Child,Integer> {
	

}
