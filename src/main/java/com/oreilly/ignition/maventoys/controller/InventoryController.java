package com.oreilly.ignition.maventoys.controller;

import java.util.List;
import com.oreilly.ignition.maventoys.entity.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.service.InventoryService;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    public List<Inventory> find() {
        return inventoryService.find();
    }
}
