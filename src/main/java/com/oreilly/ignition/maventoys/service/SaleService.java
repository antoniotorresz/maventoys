package com.oreilly.ignition.maventoys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.dto.ProductSales;
import com.oreilly.ignition.maventoys.entity.Sale;
import com.oreilly.ignition.maventoys.repository.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> find() {
        return saleRepository.findAll();
    }

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    public Optional<Sale> findById(Integer saleId) {
        return saleRepository.findById(saleId);
    }

    public void deleteById(Integer saleId) {
        saleRepository.deleteById(saleId);
    }

    public List<Sale> findByProductId(Integer productId) {
        return saleRepository.findAllSalesWithInvoicesAndProducts(productId);
    }

    public List<Object[]> findMostSoldProducts() {
        return saleRepository.findMostSoldProducts();
    }
}
