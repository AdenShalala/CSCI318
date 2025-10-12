package com.example.warehost.application.commandservices;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemId;
import com.example.warehost.domain.model.commands.ItemCommand;
import com.example.warehost.infrastructure.repository.ItemRepository;

@Service
public class ItemCommandService {
    
    private final ItemRepository itemRepository;

    public ItemCommandService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemId addItem(ItemCommand itemCommand) {
        String itemIdStr = UUID.randomUUID().toString();
        System.out.println("Generated Item ID: " + itemIdStr);
        itemCommand.setItemId(itemIdStr);
        Item item = new Item(itemCommand);
        itemRepository.save(item);
        return new ItemId(itemIdStr);
    }
}