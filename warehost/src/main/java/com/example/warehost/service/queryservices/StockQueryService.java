package com.example.warehost.service.queryservices;

import java.util.List;
import com.example.warehost.model.aggregates.ItemId;
import com.example.warehost.model.aggregates.Item;
import com.example.warehost.infrastructure.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class StockQueryService {
    
    private final ItemRepository itemRepository;

    public StockQueryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }


    /*
     * Fetches an item by its ID.
     * @param id
     * @return Item
     */
    public Item getItemById(ItemId id) {
        return itemRepository.findByItemId(id.getItemId()).orElse(null);
    }
}
