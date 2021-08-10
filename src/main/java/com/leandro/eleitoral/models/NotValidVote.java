package com.leandro.eleitoral.models;

import org.aspectj.weaver.ast.Not;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="NotValidVotes")
public class NotValidVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int votes;

    public NotValidVote(){}
    public NotValidVote(String name) {
        votes=0;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVotes() {
        this.votes++;
    }
}
