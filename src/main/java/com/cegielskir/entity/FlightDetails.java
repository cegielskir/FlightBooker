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

    private boolean cancelled;

    public FlightDetails() {}

    public FlightDetails(int id, Plane plane, boolean cancelled) {
        this.id = id;
        this.plane = plane;
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

    @Override
    public String toString() {
        return "FlightDetails{" +
                "id=" + id +
                ", plane=" + plane +
                ", cancelled=" + cancelled +
                '}';
    }
}
