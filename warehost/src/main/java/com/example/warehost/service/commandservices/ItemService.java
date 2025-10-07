package com.example.warehost.service.commandservices;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.example.warehost.infrastructure.repository.ItemRepository;
import com.example.warehost.model.aggregates.ItemId;
import com.example.warehost.model.aggregates.Item;
import com.example.warehost.model.commands.AddItemCommand;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemId addItem(AddItemCommand addItemCommand) {
        String itemIdStr = UUID.randomUUID().toString();
        System.out.println("Generated Item ID: " + itemIdStr);
        addItemCommand.setItemId(itemIdStr);
        Item item = new Item(addItemCommand);
        itemRepository.save
    }
}