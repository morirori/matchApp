package com.matchApp.dao;

import com.matchApp.enitity.VolleyballMatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolleyballMatchRepository extends CrudRepository<VolleyballMatch, String> {

    //List<VolleyballMatch> findByFirstNameAndLastName(String firstName, String lastName);
    List<VolleyballMatch>findById(Integer id);
}

