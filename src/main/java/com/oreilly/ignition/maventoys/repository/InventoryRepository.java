package com.oreilly.ignition.maventoys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.ignition.maventoys.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
    List<Inventory> findByProductId(Integer productId);
}
