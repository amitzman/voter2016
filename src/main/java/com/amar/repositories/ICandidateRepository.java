package com.amar.repositories;

import com.amar.entities.Candidate;
import com.amar.entities.Voter;
import com.amar.enums.Gender;
import com.amar.enums.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by localadmin on 8/25/16.
 */
public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Integer> {
    public List<Candidate> findByPosition(Position position);

    @Query("select distinct v from Candidate c join c.voters v where c.id = :id")
    public Page<Voter> findAllVotersByCandidateId(@Param("id") int id, Pageable pageable);

    @Query("select c.name, c.position, c.voters.size from Candidate c where c.position = :position order by c.voters.size desc")
    public List<Candidate> findWinnerByPosition(@Param("position") Position position);

    @Query("select distinct v from Candidate c join c.voters v where c.id =:id and v.gender = 'M'")
    public List<Voter> findAllVotersForSpecificCandidateByGender(@Param("id") int id);

}
