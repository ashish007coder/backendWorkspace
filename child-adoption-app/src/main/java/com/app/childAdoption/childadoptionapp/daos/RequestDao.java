package com.app.childAdoption.childadoptionapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.childAdoption.childadoptionapp.pojos.Request;

@Repository
public interface RequestDao extends JpaRepository<Request, Integer> {

}
