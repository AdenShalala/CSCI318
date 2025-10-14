package com.example.shareddomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

public class Charge implements Serializable{
    private String type;
    private List<Tag> tags = new ArrayList<>();
    private double price;
    private Sale sale; // link back to sale
    private boolean isMain;

    public Charge(String type, List<Tag> tags, double price, Sale sale, boolean isMain) {
        this.type = type;
        this.tags = tags;
        this.price = price;
        this.sale = sale;
        this.isMain = isMain;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> tags) { this.tags = tags; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Sale getSale() { return sale; }
    public void setSale(Sale sale) { this.sale = sale; }

    public boolean isMain() { return isMain; }
    public void setMain(boolean isMain) { this.isMain = isMain; }
}
