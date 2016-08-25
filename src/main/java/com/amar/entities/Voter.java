package com.amar.entities;

import com.amar.enums.Gender;
import com.amar.enums.Race;

import javax.persistence.*;

@Entity
@Table(name="voters")
public class Voter {
    private int id;
    private String name;
    private Gender gender;
    private Race race;
    private int age;

    public Voter() {
    }

    @Id
    @GeneratedValue
    public int getId() {return id; }
    public void setId(int id) {this.id = id;}

    @Column(nullable=false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M', 'F')")
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('W', 'B', 'L', 'A', 'O')")
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }

    @Column(nullable=false)
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
