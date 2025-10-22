package com.example.warehost.interfaces.rest.transform;

import com.example.warehost.domain.model.commands.ItemCommand;
import com.example.warehost.interfaces.rest.dto.ItemResource;

public class ItemCommandDTOAssembler {
    public static ItemCommand toCommandFromDTO(ItemResource itemResource) {
        return new ItemCommand(
            itemResource.getName(),
            itemResource.getType(),
            itemResource.getDescription(),
            itemResource.getQuantity()
        );
    }
}