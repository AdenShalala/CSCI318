package com.example.warehost.model.aggregates;

import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import java.util.Date;
import com.example.warehost.model.valueobjects.*;
import com.example.warehost.model.aggregates.ItemID;
import com.example.warehost.model.commands.AddItemCommand;

@Entity
@NamedQueries(
    {
        @NamedQuery(
            name = "Item.findByItemId",
            query = "SELECT i FROM Item i WHERE i.itemId = :itemId"
        ),
        @NamedQuery(
            name = "Item.findAll",
            query = "SELECT i FROM Item i"
        )
    }
)
public class Item extends AbstractAggregateRoot<Item> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Embedded
    private ItemID itemId;
    @Embedded
    private ItemType type;
    @Embedded
    private ItemDescription description;
    @Embedded
    private ItemDate order_date;

    public Item() {}

    public Item(AddItemCommand command) {
        this.itemID = new ItemID(command.getItemID());
        this.type = new ItemType(command.getType());
        this.description = new ItemDescription(command.getDescription());
        this.order_date = new ItemDate(command.getOrderDate());

        // addDomainEvent(
        //     new ItemAddedEvent(
        //         new ItemAddedEventData (
        //             command.getItemId(),
        //             command.getType(),
        //             command.getDescription(),
        //             command.getOrderDate()
        // )));
    }

    public ItemID getItemId() {
        return this.itemId;
    }

    public ItemType getType() {
        return this.type;
    }

    public ItemDescription getDescription() {
        return this.description;
    }

    public ItemDate getOrderDate() {
        return this.order_date;
    }


}
