package com.app.childAdoption.childadoptionapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.childAdoption.childadoptionapp.pojos.Parent;


@Repository
public interface ParentDao  extends JpaRepository<Parent,String>
{


}
