package com.cegielskir.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight_details")
public class FlightDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column
    private boolean cancelled;

    public FlightDetails() {}

    public FlightDetails(Plane plane, Flight flight, boolean cancelled) {
        this.plane = plane;
        this.flight = flight;
        this.cancelled = cancelled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "FlightDetails{" +
                "id=" + id +
                ", plane=" + plane +
                ", flight=" + flight +
                ", cancelled=" + cancelled +
                '}';
    }
}
