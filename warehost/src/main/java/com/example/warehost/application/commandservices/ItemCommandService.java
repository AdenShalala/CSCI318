package com.example.warehost.application.commandservices;

import java.util.UUID;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemID;
import com.example.warehost.domain.model.commands.ItemCommand;
import com.example.warehost.domain.model.valueobjects.ItemQuantity;
import com.example.warehost.infrastructure.repository.ItemRepository;
import com.example.shareddomain.events.StockLowEvent;

@Service
public class ItemCommandService {
    
    private final ItemRepository itemRepository;
    @Autowired
    private ApplicationEventPublisher publisher;

    public ItemCommandService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public ItemID addItem(ItemCommand itemCommand) {
        String itemIdStr = UUID.randomUUID().toString();
        itemCommand.setItemID(itemIdStr);
        Item item = new Item(itemCommand);
        itemRepository.save(item);

        

        return new ItemID(itemIdStr);
    }

    public void decrementStock(ItemID itemID) {
        Item item = itemRepository.findItemWithID(itemID);
        itemRepository.removeItemByID(itemID.getItemID());

        int quantity = item.getItemQuantity().getQuantityInt();
        quantity--;
        
        if (quantity <= 5) {
            StockLowEvent event = new StockLowEvent(item.getItemID().getItemID(), item.getItemName().toString(), quantity);
            publisher.publishEvent(event);
        }

        ItemQuantity itemQuantity = new ItemQuantity(quantity);

        item.setItemQuantity(itemQuantity);
        itemRepository.save(item);
    }
}