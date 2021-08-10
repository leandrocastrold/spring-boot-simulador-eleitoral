package com.leandro.eleitoral.dtos;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CandidateDTO {
    int id;
    @NotBlank (message = "Name is a mandatory field")
    private String name;
    @Min(value = 10, message = "Number must be above 9")
    @Max(value = 99, message = "Number must be bellow 99")
    private int number;
    @Size(min=1, max=1, message = "Gender must have only 1 character")
    private String gender;
    @NotBlank
    @Size(min=2, message = "State must have at least 2 characters")
    private String state;
    private int votes;
    @NotBlank
    private String party;

    public CandidateDTO(){}

    public CandidateDTO(int id, String name, int number, String gender, String state, String party) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.state = state;
        this.votes = 0;
        this.party = party;
    }

    public CandidateDTO( String name, int number, String gender, String state, String party) {
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

//    public void setId(int id) {
//        this.id = id;
//    }


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

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "CandidateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                ", votes=" + votes +
                '}';
    }
}
