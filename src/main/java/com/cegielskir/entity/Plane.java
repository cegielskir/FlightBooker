package com.cegielskir.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column( name = "model")
    private String model;

    @Temporal(TemporalType.DATE)
    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column( name = "now_used")
    private boolean nowUsed;

    @Column(name = "passengers_number")
    private int passengersNumber;

    public Plane() {}

    public Plane(String model, Date purchaseDate, boolean nowUsed, int passengersNumber) {
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.nowUsed = nowUsed;
        this.passengersNumber = passengersNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public boolean isNowUsed() {
        return nowUsed;
    }

    public void setNowUsed(boolean nowUsed) {
        this.nowUsed = nowUsed;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", nowUsed=" + nowUsed +
                ", passengersNumber=" + passengersNumber +
                '}';
    }
}
