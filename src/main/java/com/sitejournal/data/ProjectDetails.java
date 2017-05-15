package com.sitejournal.data;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Muresan Andrei
 * */

@Entity
@Table(name = "project_details")
public class ProjectDetails implements Serializable {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameOfProject;
    private String stardDate;
    private String endDate;
    private String street;
    private String country;
    private String state;

    public ProjectDetails(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfProject() {
        return nameOfProject;
    }

    public void setNameOfProject(String nameOfProject) {
        this.nameOfProject = nameOfProject;
    }

    public String getStardDate() {
        return stardDate;
    }

    public void setStardDate(String stardDate) {
        this.stardDate = stardDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "id=" + id +
                ", nameOfProject='" + nameOfProject + '\'' +
                ", stardDate='" + stardDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
