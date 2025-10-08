package com.example.sales.interfaces.rest.transform;

import com.example.sales.domain.model.commands.SalesCommand;
import com.example.sales.interfaces.rest.dto.SalesResource;

public class SalesCommandDTOAssembler {
    public static SalesCommand toCommandFromDTO(SalesResource salesResource) {
        return new SalesCommand(
            salesResource.getCharge(),
            salesResource.getDate(),
            salesResource.getAdditionalCharges()
        );
    }
}
