package com.oreilly.ignition.maventoys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.ignition.maventoys.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer>{
    
}
