package com.example.warehost.application.queryservices;

import java.util.List;

import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemID;
import com.example.warehost.infrastructure.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class StockQueryService {
    
    private final ItemRepository itemRepository;

    public StockQueryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findItemWithID(ItemID itemID) {
        return itemRepository.findItemWithID(itemID);
    }

    public void removeItemByID(String id){
        itemRepository.removeItemByID(id);
    }
}
