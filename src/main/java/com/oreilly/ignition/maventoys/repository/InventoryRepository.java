package com.oreilly.ignition.maventoys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.ignition.maventoys.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
    
}
