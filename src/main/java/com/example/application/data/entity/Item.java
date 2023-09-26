package com.example.application.data.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Item extends AbstractEntity {
    
    @NotBlank
    private String childName;

    @NotBlank
    private int priceInEuros;

    @NotBlank
    private String item;

    public String childName() {
        return this.childName;
    }
    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getPriceInEuros() {
        return this.priceInEuros;
    }

    public void setPriceInEuros(int priceInEuros) {
        this.priceInEuros = priceInEuros;
    }
}
