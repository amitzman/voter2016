package com.amar.entities;

import com.amar.enums.Party;
import com.amar.enums.Position;


import javax.persistence.*;
import java.util.List;

/**
 * Created by localadmin on 8/25/16.
 */
@Entity
@Table(name="candidates")
public class Candidate {
    private int id;
    private String name;
    private Party party;
    private Position position;
    private List<Voter> voters;

    public Candidate() {
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('D', 'R')")
    public Party getParty() {
        return party;
    }
    public void setParty(Party party) {
        this.party = party;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('President', 'Governor', 'Senator')")
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidates_voters",
            joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"))
    public List<Voter> getVoters() {
        return voters;
    }
    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }
}
