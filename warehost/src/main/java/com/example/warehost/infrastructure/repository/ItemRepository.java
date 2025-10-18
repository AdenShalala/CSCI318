package com.example.warehost.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemID;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemWithID(ItemID itemID);
    List<Item> findAllItems();
    void removeItemByID(String itemID);
}
