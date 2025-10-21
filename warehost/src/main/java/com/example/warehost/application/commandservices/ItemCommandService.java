package com.example.warehost.application.commandservices;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemID;
import com.example.warehost.domain.model.commands.ItemCommand;
import com.example.warehost.domain.model.valueobjects.ItemQuantity;
import com.example.warehost.infrastructure.repository.ItemRepository;

@Service
public class ItemCommandService {
    
    private final ItemRepository itemRepository;

    public ItemCommandService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemID addItem(ItemCommand itemCommand) {
        String itemIdStr = UUID.randomUUID().toString();
        itemCommand.setItemID(itemIdStr);
        Item item = new Item(itemCommand);
        itemRepository.save(item);
        return new ItemID(itemIdStr);
    }

    public void decrementStock(ItemID itemID) {
        Item item = itemRepository.findItemWithID(itemID);
        
        item.getItemQuantity().setQuantityInt(item.getItemQuantity().getQuantityInt() - 1);
        
        itemRepository.save(item);
    }
}