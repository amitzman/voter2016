package com.amar.services;

import com.amar.entities.Candidate;
import com.amar.entities.Voter;
import com.amar.enums.Position;
import com.amar.repositories.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by localadmin on 8/25/16.
 */

@Service
public class CandidateService {

    private ICandidateRepository repository;

    @Autowired
    public void setRepository(ICandidateRepository repository){
        this.repository = repository;
    }

    public Page<Candidate> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }
    public Candidate findOne(int id) {
        return this.repository.findOne(id);
    }

    public Candidate create(Candidate candidate) {
        return this.repository.save(candidate);
    }

    public List<Candidate> findByPosition(Position position){
        return this.repository.findByPosition(position);
    }

    public Page<Voter> findAllVotersByCandidateId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAllVotersByCandidateId(id, pr);
    }

    public List<Candidate> findWinnerByPosition(Position position) {
        return this.repository.findWinnerByPosition(position);
    }

}
