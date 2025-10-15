package com.example.promotions.domain.model.aggregates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.example.promotions.domain.model.commands.PromoCommand;
import com.example.promotions.domain.model.valueobjects.Discount;
import com.example.promotions.domain.model.valueobjects.ItemID;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
@Entity
@NamedQueries ({
    @NamedQuery (name="Promotion.findAllPromotions", query="SELECT p from Promotion p"),
    @NamedQuery (name="Promotion.findAllPromotionIDs", query="SELECT p.PromoID from Promotion p"),
    @NamedQuery (name="Promotion.findPromoWithID", query="SELECT p FROM Promotion p WHERE p.promoID = ?1"),
    @NamedQuery (name="Promotion.findPromoWithItemID", query="SELECT p FROM Promotion p WHERE p.itemID = ?1")
})
public class Promotion extends AbstractAggregateRoot<Promotion>{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    private String startDate;
    private String endDate;
    @Embedded
    private PromoID promoID;

    @jakarta.persistence.ElementCollection
    @Embedded
    private List<ItemID> items = new ArrayList<>();
    private String promoCode;
    @Embedded
    private Discount discount;

    public Promotion() {}

    public Promotion(String startDate, String endDate, PromoID promoID, List<ItemID> items, String promoCode, Discount discount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.promoID = promoID;
        this.items = items;
        this.promoCode = promoCode;
        this.discount = discount;
    }

    public Promotion(PromoCommand promoCommand) {
        this.startDate = promoCommand.getStartDate();
        this.endDate = promoCommand.getEndDate();
        this.promoID = new PromoID(promoCommand.getPromoID());
        this.items = promoCommand.getItems();
        this.promoCode = promoCommand.getPromoCode();
        this.discount = promoCommand.getDiscount();
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getStartDate() { return this.startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return this.endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public PromoID getPromoID() { return this.promoID; }
    public void setPromoID(PromoID promoID) { this.promoID = promoID; }

    public List<ItemID> getItems() { return this.items; }
    public void setItems(List<ItemID> items) { this.items = items; }

    public String getPromoCode() { return this.promoCode; }
    public void setPromoCode(String promoCode) { this.promoCode = promoCode; }

    public Discount getDiscount() { return this.discount; }
    public void setDiscount(Discount discount) { this.discount = discount; }
}
