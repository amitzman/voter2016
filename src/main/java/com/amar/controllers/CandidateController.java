package com.amar.controllers;

import com.amar.entities.Voter;
import com.amar.entities.Candidate;
import com.amar.enums.Position;
import com.amar.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidateController {
    private CandidateService service;

    @Autowired
    public void setService(CandidateService service ) { this.service = service; }


    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Candidate> index(@RequestParam(name="page", required=false, defaultValue="0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path= {"/{id}"}, method = RequestMethod.GET)
    public Candidate show(@PathVariable int id) {return this.service.findOne(id); }

    @RequestMapping(path= {"", "/"}, method = RequestMethod.POST)
    public Candidate create(@RequestBody Candidate candidate){
        return this.service.create(candidate);
    }

    @RequestMapping(path = {"position/{position}"}, method = RequestMethod.GET)
    public List<Candidate> findByPosition(@PathVariable Position position) {
        return this.service.findByPosition(position);
    }

    @RequestMapping(path = {"/{id}/voters"}, method = RequestMethod.GET)
    public Page<Voter> voters(@PathVariable int id, @RequestParam(name="page", required=false, defaultValue="0") int page) {
        return this.service.findAllVotersByCandidateId(id, page);
    }

    @RequestMapping(path = {"/{position}/winner"}, method = RequestMethod.GET)
    public List<Candidate> findWinnerByPosition(@PathVariable Position position) {
        return this.service.findWinnerByPosition(position);
    }
}
