package com.app.childAdoption.childadoptionapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.childAdoption.childadoptionapp.pojos.Ngo;

@Repository
public interface NgoDao extends JpaRepository<Ngo, Integer>{

}
