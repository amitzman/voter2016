package com.amar.controllers;

import com.amar.entities.Candidate;
import com.amar.entities.Voter;
import com.amar.enums.Gender;
import com.amar.enums.Race;
import com.amar.services.VoterService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/voters")
public class VoterController {
    private VoterService service;

    @Autowired
    public void setService(VoterService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Voter> index(@RequestParam(name="page", required=false, defaultValue="0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path= {"/{id}"}, method = RequestMethod.GET)
    public Voter show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path= {"", "/"}, method = RequestMethod.POST)
    public Voter create(@RequestBody Voter voter) {
        return this.service.create(voter);
    }

    @RequestMapping(path={"race/{race}"}, method = RequestMethod.GET)
    public List<Voter> findByRace(@PathVariable Race race) {
        return this.service.findByRace(race);
    }

    @RequestMapping(path={"gender/{gender}"}, method = RequestMethod.GET)
    public List<Voter> findByGender(@PathVariable Gender gender) {
        return this.service.findByGender(gender);
    }

    @RequestMapping(path={"candidates/{id}"}, method = RequestMethod.GET)
    public List<Candidate> findAllCandidatesByVoterId(@PathVariable int id) {
        return this.service.findAllCandidatesByVoterId(id);
    }
}
