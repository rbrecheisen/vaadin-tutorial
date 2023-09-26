package com.example.application.data.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class CarTrip extends AbstractEntity {
    
    @NotBlank
    private String brand;

    @NotBlank
    private int kilometers;

    @NotBlank
    private String destination;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKilometers() {
        return this.kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
