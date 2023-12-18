package com.oreilly.ignition.maventoys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oreilly.ignition.maventoys.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("SELECT s FROM Sale s JOIN s.products p WHERE p.id = :productId")
    List<Sale> findByProductId(@Param("productId") Integer productId);

}
