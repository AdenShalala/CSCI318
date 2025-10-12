package com.example.warehost.interfaces.rest.transform;

import com.example.warehost.domain.model.commands.ItemCommand;
import com.example.warehost.interfaces.rest.dto.ItemResource;

public class ItemCommandDTOAssembler {
    public static ItemCommand toCommandFromDTO(ItemResource itemResource) {
        return new ItemCommand(
            itemResource.getItemID(),
            itemResource.getType(),
            itemResource.getDescription(),
            java.sql.Date.valueOf(itemResource.getOrderDate()) // Convert String to Date
        );
    }
}