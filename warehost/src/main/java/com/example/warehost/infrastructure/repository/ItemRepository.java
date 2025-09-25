package com.example.warehost.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.warehost.model.aggregates.Item;
import com.example.warehost.model.aggregates.ItemId;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByItemId(ItemId itemId);
    List<Item> findAll();
}
