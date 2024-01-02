package com.oreilly.ignition.maventoys.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.service.StoreService;
import com.oreilly.ignition.maventoys.entity.Store;
@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    public List<Store> find() {
        return storeService.find();
    }
}
