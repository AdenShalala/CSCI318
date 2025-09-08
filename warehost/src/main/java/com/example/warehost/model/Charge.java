package com.example.warehost.model;

import java.util.*;

public class Charge {
    private String type;
    private ArrayList<String> tags = new ArrayList<String>();
    private double price;

    public Charge(){}

    public Charge(String type, ArrayList<String> tags, double price) {
        this.type = type;
        this.tags = tags;
        this.price = price;
    }
}
