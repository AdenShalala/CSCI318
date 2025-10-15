package com.example.promotions.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.promotions.domain.model.aggregates.Promotion;

public interface PromoRepository extends JpaRepository<Promotion, Long>{
    public List<Promotion> findAllPromotions();
}
