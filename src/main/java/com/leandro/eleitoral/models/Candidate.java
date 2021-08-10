package com.leandro.eleitoral.models;

import javax.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private int number;
    private String gender;
    private String state;
    private int votes;
    private String party;

    public Candidate(){}

    public Candidate(int id, String name, int number, String gender, String state, String party) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.state = state;
        this.votes = 0;
        this.party = party;
    }
    public Candidate(String name, int number, String gender, String state, String party) {
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.state = state;
        this.votes = 0;
        this.party = party;
    }

    public int getId() {
        return id;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        this.votes++;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                ", votes=" + votes +
                '}';
    }
}


