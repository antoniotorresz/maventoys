package com.oreilly.ignition.maventoys.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.entity.Inventory;

import com.oreilly.ignition.maventoys.repository.InventoryRepository;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> find() {
        return inventoryRepository.findAll();
    }

    public List<Inventory> findByProductId(Integer productId) {
        return inventoryRepository.findByProductId(productId);
        // return inventoryRepository.findAll()
        //         .stream()
        //         .filter(i -> i.getProduct().getId().equals(productId))
        //         .collect(java.util.stream.Collectors.toSet()).stream().toList().stream()
        //         .sorted(Comparator.comparing(Inventory::getId)).collect(Collectors.toList());
    }
}
