package com.example.warehost.application.commandservices;

import java.util.UUID;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemID;
import com.example.warehost.domain.model.commands.ItemCommand;
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

    
    public ItemID addItem(ItemCommand itemCommand) {
        String itemIdStr = UUID.randomUUID().toString();
        itemCommand.setItemID(itemIdStr);
        Item item = new Item(itemCommand);
        itemRepository.save(item);

        return new ItemID(itemIdStr);
    }
    
    @Transactional
    public void decrementStock(ItemID itemID) {
        System.out.println("Decrement Stock Function");
        Item item = itemRepository.findItemWithID(itemID);

        try {
            System.out.println("Decrement Stock Function 2");
            //TEMP CATCH FOR TESTING
            int quantity = item.getItemQuantity().getQuantityInt();
            item.getItemQuantity().setQuantityInt(quantity - 1);

            StockLowEvent event = new StockLowEvent(item.getItemID().getItemID(), item.getItemName().toString(), quantity);
            publisher.publishEvent(event);
            itemRepository.save(item);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
       
    }
}