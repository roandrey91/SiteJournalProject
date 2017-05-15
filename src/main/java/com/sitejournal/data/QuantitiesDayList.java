package com.sitejournal.data;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Muresan Andrei
 * */

@Entity
@Table(name = "quantities")
public class QuantitiesDayList implements Serializable {

    @Id
    @Column(name = "quantities_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double kgOfMaterial;
    private int pieces;
    private String nameOfMaterial;
    private Date dayDate;

    public QuantitiesDayList() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getKgOfMaterial() {
        return kgOfMaterial;
    }

    public void setKgOfMaterial(double kgOfMaterial) {
        this.kgOfMaterial = kgOfMaterial;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public String getNameOfMaterial() {
        return nameOfMaterial;
    }

    public void setNameOfMaterial(String nameOfMaterial) {
        this.nameOfMaterial = nameOfMaterial;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }
}
