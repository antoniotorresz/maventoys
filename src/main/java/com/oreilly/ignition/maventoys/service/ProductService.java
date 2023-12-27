package com.oreilly.ignition.maventoys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.entity.Product;
import com.oreilly.ignition.maventoys.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(Pageable pageable) {
        if (pageable != null) {
            return productRepository.findAll(pageable).toList();
        }
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

    public List<Product> findByActive(Boolean active, Pageable pageable) {
        if (pageable == null) {
            return productRepository.findAll()
                .stream().filter(p -> p.getActive() == active).toList();
        }
        return productRepository.findAll(pageable)
                .stream().filter(p -> p.getActive() == active).toList();
    }

    public List<Product> getBestSellers() {
        return productRepository.findAll()
                .stream().sorted((p1, p2) -> p2.getSales().size() - p1.getSales().size()).toList();
    }

    public List<Product> getBestSellers(List<Product> products) {
        for (Product product : products) {
            this.save(product);
        }
        return products;
    }

    public void updatePriceAndCost(Integer productId, Double price, Double cost) {
        System.out.println("Updating price and cost for product " + productId + " to " + price + " and " + cost);
        productRepository.updatePriceAndCost(productId, price, cost);
    }

}
