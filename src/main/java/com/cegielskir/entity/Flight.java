package com.cegielskir.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import java.util.Date;
import java.util.Random;


@Entity
@Table(name="flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Size(min = 6, max = 10, message = "Length muse be between 6 and 10")
    @Column(name="name")
    private String name;

    //@DateTimeFormat(pattern="hh:mm")
    @Temporal(TemporalType.TIME)
    @Column(name="departure_time")
    private Date departureTime;

    @Temporal(TemporalType.DATE)
    @Column(name="departure_date")
    private Date departureDate;


    //@DateTimeFormat(pattern="hh:mm")
    @Temporal(TemporalType.TIME)
    @Column(name="arrival_time")
    private Date arrivalTime;


    @Temporal(TemporalType.DATE)
    @Column(name="arrival_date")
    private Date arrivalDate;

    @NotNull(message = "Please choose source airport")
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="from_airport_id")
    private Airport fromAirport;

    @NotNull(message = "Please choose destination airport")
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="to_airport_id")
    private Airport toAirport;

    @Column(name="cancelled")
    private boolean cancelled;

    @OneToOne(mappedBy = "flight",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private FlightDetails flightDetails;


    public Flight() {}

    public Flight(String name, Date departureTime, Date departureDate, Date arrivalTime,
                  Date arrivalDate, Airport fromAirport, Airport toAirport) {
        this.name = name;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.cancelled = false;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public FlightDetails getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(FlightDetails flightDetails) {
        this.flightDetails = flightDetails;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departureTime=" + departureTime +
                ", departureDate=" + departureDate +
                ", arrivalTime=" + arrivalTime +
                ", arrivalDate=" + arrivalDate +
                ", fromAirport=" + fromAirport +
                ", toAirport=" + toAirport +
                ", cancelled=" + cancelled +
                '}';
    }
}
