package com.example.warehost.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemId;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByItemId(String itemID);
    List<Item> findAll();
    void removeByID(String itemID);
}
