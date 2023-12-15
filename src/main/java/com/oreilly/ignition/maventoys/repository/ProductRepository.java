package com.oreilly.ignition.maventoys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.ignition.maventoys.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
