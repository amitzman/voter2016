package com.amar.repositories;


import com.amar.entities.Candidate;
import com.amar.entities.Voter;
import com.amar.enums.Gender;
import com.amar.enums.Race;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVoterRepository extends PagingAndSortingRepository<Voter, Integer> {

    @Query("select distinct c from Candidate c join c.voters v where v.id = :id")
    public List<Candidate> findAllCandidatesByVoterId(@Param("id") int id);

    public List<Voter> findByRace(Race race);


    List<Voter> findByGender(Gender gender);
}
