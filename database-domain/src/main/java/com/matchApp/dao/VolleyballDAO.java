package com.matchApp.dao;

//import com.matchApp.enitity.User;
import com.matchApp.enitity.User;
import com.matchApp.enitity.VolleyballMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VolleyballDAO {
    private final String succes = "OK";

    @Autowired
    private VolleyballMatchRepository repository;

    public VolleyballDAO() {
    }

    public Boolean addMatch(VolleyballMatch match){
        repository.save(match);
        return true;
    }

    public List getAllMatches() {
        ArrayList<VolleyballMatch> VolleyballMatch = new ArrayList<>();
        for (VolleyballMatch match : repository.findAll()) {
            VolleyballMatch.add(match);
        }
        return VolleyballMatch;
    }
}
