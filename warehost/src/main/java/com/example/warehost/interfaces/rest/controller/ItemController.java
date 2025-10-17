package com.example.warehost.interfaces.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.warehost.application.commandservices.ItemCommandService;
import com.example.warehost.application.queryservices.StockQueryService;
import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemID;
import com.example.warehost.interfaces.rest.dto.ItemResource;
import com.example.warehost.interfaces.rest.transform.ItemCommandDTOAssembler;

@Controller
@RequestMapping("/items")
public class ItemController {
    private ItemCommandService itemCommandService;
    private StockQueryService itemQueryService;

    public ItemController(ItemCommandService itemCommandService, StockQueryService itemQueryService) {
        this.itemCommandService = itemCommandService;
        this.itemQueryService = itemQueryService;
    }

    @PostMapping
    @ResponseBody
    public ItemID addItem(@RequestBody ItemResource itemResource) {
        ItemID itemID = itemCommandService.addItem(ItemCommandDTOAssembler.toCommandFromDTO(itemResource));
        System.out.println("Now adding Item " + itemID);
        return itemID;
    }

    @GetMapping("/findAllItems")
    @ResponseBody
    public List<Item> findAllItems() {
        final List<Item> items = itemQueryService.findAllItems();
        System.out.println("[[ALL ITEMS]]");
        for (Item item: items) {
            System.out.println(item);
        }
        return items;
    }
    @GetMapping("findItemWithID")
    @ResponseBody
    public Item findItemWithID(@RequestParam("ItemID") String id) {
        
        Item item = itemQueryService.findItemWithID(new ItemID(id));
        System.out.println(item);
        return item;
    }
}
