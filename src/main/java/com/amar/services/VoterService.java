package com.amar.services;

import com.amar.entities.Candidate;
import com.amar.entities.Voter;
import com.amar.enums.Gender;
import com.amar.enums.Position;
import com.amar.enums.Race;
import com.amar.repositories.IVoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {
    private IVoterRepository repository;

    @Autowired
    public void setRepository(IVoterRepository repository){
        this.repository = repository;
    }

    public Page<Voter> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Voter findOne(int id) {
        return this.repository.findOne(id);
    }

    public Voter create(Voter voter) {
        return this.repository.save(voter);
    }

    public List<Candidate> findAllCandidatesByVoterId(int id) { return this.repository.findAllCandidatesByVoterId(id);}

    public List<Voter> findByRace(Race race) { return this.repository.findByRace(race);}

    public List<Voter> findByGender(Gender gender) { return this.repository.findByGender(gender);}

}
