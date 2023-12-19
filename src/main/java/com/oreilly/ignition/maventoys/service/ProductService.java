package com.oreilly.ignition.maventoys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.entity.Product;
import com.oreilly.ignition.maventoys.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByActive(Integer active) {
        return productRepository.findAll()
                .stream().filter(p -> p.getActive() == active).toList();
    }

    public List<Product> getBestSellers() {
        return productRepository.findAll()
                .stream().sorted((p1, p2) -> p2.getSales().size() - p1.getSales().size()).toList();
    }
}
