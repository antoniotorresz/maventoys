package com.oreilly.ignition.maventoys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.entity.Store;
import com.oreilly.ignition.maventoys.repository.StoreRepository;

@Service
public class StoreService {
    @Autowired
    private StoreRepository repository;

    public List<Store> find() {
        return repository.findAll();
    }
    public Optional<Store> findById(Integer id) {
        return repository.findById(id);
    }

    public Store save(Store store) {
        return repository.save(store);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    
}
