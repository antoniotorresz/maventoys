package com.oreilly.ignition.maventoys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.ignition.maventoys.model.entity.Inventory;

/**
 * This interface represents a repository for managing inventory data.
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    /**
     * Retrieves a list of inventory items based on the given product ID.
     *
     * @param productId the ID of the product
     * @return a list of inventory items
     */
    List<Inventory> findByProductId(Integer productId);
}
