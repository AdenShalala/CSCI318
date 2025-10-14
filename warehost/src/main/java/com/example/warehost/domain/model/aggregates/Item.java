package com.example.warehost.domain.model.aggregates;

import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import com.example.warehost.domain.model.aggregates.ItemId;
import com.example.warehost.domain.model.commands.ItemCommand;
import com.example.warehost.domain.model.valueobjects.*;

// import jakarta.persistence.Embedded;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.NamedQueries;
// import jakarta.persistence.NamedQuery;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.JoinColumn;

import java.util.Date;

@Entity
@NamedQueries(
    {
        @NamedQuery(
            name = "Item.findByItemId",
            query = "SELECT i FROM Item i WHERE i.itemId = ?1"
        ),
        @NamedQuery(
            name = "Item.findAll",
            query = "SELECT i FROM Item i"
        ),
        @NamedQuery(
            name = "Item.removeByID",
            query = "DELETE FROM Item i WHERE i.itemID = ?1"
        )
    }
)
public class Item extends AbstractAggregateRoot<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ItemId itemId;
    @Embedded
    private ItemType type;
    @Embedded
    private ItemDescription description;
    @Embedded
    private ItemDate order_date;

    public Item() {}

    public Item(ItemCommand command) {
        this.itemId = new ItemId(command.getItemId());
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

    public ItemId getItemId() {return this.itemId;}
    public ItemType getType() {return this.type;}
    public ItemDescription getDescription() {return this.description;}
    public ItemDate getOrderDate() {return this.order_date;}


}
