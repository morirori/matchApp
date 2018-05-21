package com.matchApp.webServices;

import com.matchApp.dao.VolleyballMatchRepository;
import com.matchApp.enitity.VolleyballMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volleyballmatch")

public class VolleyballMatchWebServicesController {

    @Autowired
    VolleyballMatchRepository repository;

    @RequestMapping(value = "/saveMatch")
    public String sampleSave(){
        VolleyballMatch sample=new VolleyballMatch();
        repository.save(sample);
        return "success:";
   }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Iterable<VolleyballMatch> getAll() {
        Iterable<VolleyballMatch> toReturn = repository.findAll();
        return toReturn;
    }
}
