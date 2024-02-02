package com.product.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.data.repository.cdi.Eager;

@Entity

public class Features {
    @Id
    @GeneratedValue
    private int id;
    private String storage;
    private String processor;
    private String battery;

    @ManyToOne
    private Products products;

    public int getId() {
        return id;
    }

    public String getStorage() {
        return storage;
    }

    public String getProcessor() {
        return processor;
    }

    public String getBattery() {
        return battery;
    }

    public Products getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
