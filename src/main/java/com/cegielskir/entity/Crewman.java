package com.cegielskir.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "crewman")
public class Crewman {

    private static List<String> roles = new ArrayList<>(
            Arrays.asList("Main Pilot", "Secondary Pilot", "Flight Attendant")
    );

    //TODO form patterns and restrictions

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;

    @Temporal(TemporalType.DATE)
    @Column(name = "employment_date")
    private Date employmentDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dismissal_date")
    private Date dismissalDate;

    public Crewman() {}

    public Crewman(String firstName, String lastName, String email, String phoneNumber,
                   String role, Address address, Date employmentDate, Date dismissalDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;
        this.employmentDate = employmentDate;
        this.dismissalDate = dismissalDate;
    }

    public static List<String> getRoles() {
        return roles;
    }

    public static void setRoles(List<String> roles) {
        Crewman.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(Date dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    @Override
    public String toString() {
        return "Crewman: " +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'';
    }
}
