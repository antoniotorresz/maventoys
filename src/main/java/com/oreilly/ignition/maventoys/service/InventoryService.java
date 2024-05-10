package com.oreilly.ignition.maventoys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.model.entity.Inventory;
import com.oreilly.ignition.maventoys.repository.InventoryRepository;
import com.oreilly.ignition.maventoys.repository.ProductRepository;

/**
 * This class represents a service for managing inventory.
 */
@Service
public class InventoryService {
    /**
     * The repository used for accessing inventory data.
     */
    private final InventoryRepository inventoryRepository;

    /**
     * Constructs a new InventoryService with the specified InventoryRepository and
     * ProductRepository.
     *
     * @param newInventoryRepository the repository used for accessing inventory
     *                               data
     * @param productRepository      the repository used for accessing product data
     */
    public InventoryService(final InventoryRepository newInventoryRepository,
            final ProductRepository productRepository) {
        this.inventoryRepository = newInventoryRepository;
    }

    /**
     * Retrieves all inventory items.
     *
     * @return a list of all inventory items
     */
    public List<Inventory> find() {
        return inventoryRepository.findAll();
    }
}
