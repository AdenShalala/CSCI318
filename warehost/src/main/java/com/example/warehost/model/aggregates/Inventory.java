package com.example.warehost.model.aggregates;

import java.util.*;

import com.example.warehost.model.Sale;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int capacity;
    private String description;
    private ArrayList<String> categories = new ArrayList<String>();
    private ArrayList<Sale> sales = new ArrayList<Sale>();

    public Inventory(){}

    public Inventory(ArrayList<Item> items, int capacity, String description, ArrayList<String> categories, ArrayList<Sale> sales) {
        this.items = items;
        this.capacity = capacity;
        this.description = description;
        this.categories = categories;
        this.sales = sales;
    }
}
