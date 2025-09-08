package com.example.warehost.model;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Item> items = new ArrayList<Item>();
    private Charge charge;
    private ArrayList<Double> additional_charges = new ArrayList<Double>();

    public Sale(){}

    public Sale(ArrayList<Item> items, Charge charge, ArrayList<Double> additional_charges) {
        this.items = items;
        this.charge = charge;
        this.additional_charges = additional_charges;
    }
}
