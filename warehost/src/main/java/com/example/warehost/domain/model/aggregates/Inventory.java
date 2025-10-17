package com.example.warehost.domain.model.aggregates;

import java.util.*;
import com.example.warehost.infrastructure.repository.ItemRepository;

//import com.example.warehost.domain.model.Sale;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;
    private ArrayList<String> categories = new ArrayList<String>();
    private final ItemRepository itemRepository;
    //private ArrayList<Sale> sales;
    // need to add sales from external data source

    public Inventory(ArrayList<Item> items, int capacity, ArrayList<String> categories, /*ArrayList<Sale> sales,*/ ItemRepository itemRepository) {
        this.items = new ArrayList<Item>(itemRepository.findAll());
        this.capacity = capacity;
        this.categories = categories;
        //this.sales = new ArrayList<Sale>(); // Needs external data to populate - h
        this.itemRepository = itemRepository;
    }

    public ArrayList<Item> getItems() {return items;}
    public int getCapacity() {return capacity;}
    public ArrayList<String> getCategories() {return categories;}
    //public ArrayList<Sale> getSales() {return sales;}

    public void setItems(ArrayList<Item> items) {this.items = items;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
    public void setCategories(ArrayList<String> categories) {this.categories = categories;}
    //public void setSales(ArrayList<Sale> sales) {this.sales = sales;}

    public void removeItemByID(String id) {
        ItemID itemID = new ItemID(id);
        items.removeIf(item -> item.getItemID().equals(itemID));
        for (Item item : items) {
            if (itemID == item.getItemID()) {
                this.itemRepository.removeItemByID(id);
            }
        }
    }

    public ItemID addToInventory(Item item){
        itemRepository.save(item);
        this.items.add(item);
        return item.getItemID();
    }

    public String toString() {
        String itemList = "";
        for (Item item : items) {
            itemList += item.toString() + "\n";
        }
        String categoriesList = "";
        for (String category : categories) {
            categoriesList += category + "\n";
        }

        return "=== Inventory ===\n# items #\n" + itemList + "# capacity #\n" + capacity + "\n# categories #" + categoriesList;
    }
}
