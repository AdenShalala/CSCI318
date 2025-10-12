package com.example.warehost.model.aggregates;

import java.util.*;

import com.example.warehost.model.Sale;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;
    private ArrayList<String> categories = new ArrayList<String>();
    private ArrayList<Sale> sales;

    public Inventory(){}

    public Inventory(ArrayList<Item> items, int capacity, ArrayList<String> categories, ArrayList<Sale> sales) {
        this.items = new ArrayList<Item>();
        this.capacity = capacity;
        this.categories = categories;
        this.sales = new ArrayList<Sale>(); // Needs external data to populate - h
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    
}
