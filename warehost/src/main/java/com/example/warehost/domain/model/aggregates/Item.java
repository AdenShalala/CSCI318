package com.example.warehost.domain.model.aggregates;

import jakarta.persistence.*;

import org.springframework.data.domain.AbstractAggregateRoot;

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

@Entity
@NamedQueries(
    {
        @NamedQuery(
            name = "Item.findItemWithID",
            query = "SELECT i FROM Item i WHERE i.itemID = ?1"
        ),
        @NamedQuery(
            name = "Item.findAllItems",
            query = "SELECT i FROM Item i"
        ),
        @NamedQuery(
            name = "Item.removeItemByID",
            query = "DELETE FROM Item i WHERE i.itemID = ?1"
        )
    }
)
public class Item extends AbstractAggregateRoot<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ItemID itemID;
    @Embedded
    private ItemName name;
    @Embedded
    private ItemType type;
    @Embedded
    private ItemDescription description;
    @Embedded
    private ItemQuantity quantity;

    public Item() {}

    public Item(ItemCommand command) {
        this.itemID = new ItemID(command.getItemID());
        this.name = new ItemName(command.getItemName());
        this.type = new ItemType(command.getType());
        this.description = new ItemDescription(command.getDescription());
        this.quantity = new ItemQuantity(Integer.valueOf(command.getQuantity()));

        // addDomainEvent(
        //     new ItemAddedEvent(
        //         new ItemAddedEventData (
        //             command.getItemId(),
        //             command.getType(),
        //             command.getDescription(),
        //             command.getOrderDate()
        // )));
    }

    public ItemID getItemID() {return this.itemID;}

    public ItemName getItemName() {return this.name;}
    public void setItemName(ItemName itemName) {this.name = itemName;}

    public ItemType getType() {return this.type;}
    public void setType(ItemType type) {this.type = type;}

    public ItemDescription getDescription() {return this.description;}
    public void setDescription(ItemDescription description) {this.description = description;}
   
    public ItemQuantity getItemQuantity() {return this.quantity;}
    public void setItemQuantity(ItemQuantity quantity) {this.quantity = quantity;}

    public String toString() {
        return "=== Item ===\n" + this.name + "\nID: " + this.itemID + "\nType: " + this.type + "\nDescription: " + this.description + "\nQuantity: " + this.quantity;
    }
}
