package com.example.warehost.domain.model.aggregates;

import java.util.*;

//import com.example.warehost.domain.model.Sale;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;
    private ArrayList<String> categories = new ArrayList<String>();
    //private ArrayList<Sale> sales;
    // need to add sales from external data source

    public Inventory(){}

    public Inventory(ArrayList<Item> items, int capacity, ArrayList<String> categories, ArrayList<Sale> sales) {
        this.items = new ArrayList<Item>();
        this.capacity = capacity;
        this.categories = categories;
        //this.sales = new ArrayList<Sale>(); // Needs external data to populate - h
    }
}
