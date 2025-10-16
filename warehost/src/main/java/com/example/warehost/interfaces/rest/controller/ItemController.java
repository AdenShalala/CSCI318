package com.example.warehost.interfaces.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.warehost.application.commandservices.ItemCommandService;
import com.example.warehost.application.queryservices.StockQueryService;
import com.example.warehost.domain.model.aggregates.Item;
import com.example.warehost.domain.model.aggregates.ItemId;
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
    public ItemId addItem(@RequestBody ItemResource itemResource) {
        ItemId itemId = itemCommandService.addItem(ItemCommandDTOAssembler.toCommandFromDTO(itemResource));
        System.out.println("Now adding Item " + itemId);
        return itemId;
    }

    @GetMapping("/findAllItems")
    @ResponseBody
    public List<Item> findAllItems() {
        final List<Item> items = itemQueryService.getAllItems();
        System.out.println("[[ALL ITEMS]]");
        for (Item item: items) {
            System.out.println(item);
        }
        return items;
    }
    @GetMapping("findByID")
    @ResponseBody
    public Item findByID(@RequestBody String id) {
        Item item = itemQueryService.getItemById(id);
        return item;
    }
}
