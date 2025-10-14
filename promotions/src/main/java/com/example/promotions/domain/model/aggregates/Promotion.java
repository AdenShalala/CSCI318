package com.example.promotions.domain.model.aggregates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.example.promotions.domain.model.valueobjects.Discount;
import com.example.promotions.domain.model.valueobjects.ItemID;
import com.example.promotions.domain.model.valueobjects.PromoID;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
@Entity
@NamedQueries ({
    @NamedQuery (name="Promotion.findAllPromotions", query="SELECT p from Promotion.p")
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
}
