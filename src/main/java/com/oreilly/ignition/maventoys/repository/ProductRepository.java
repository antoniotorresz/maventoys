package com.oreilly.ignition.maventoys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oreilly.ignition.maventoys.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = :price, p.cost = :cost WHERE p.id = :productId")
    void updatePriceAndCost(@Param("productId") Integer productId, @Param("price") Double price,
            @Param("cost") Double cost);

}
