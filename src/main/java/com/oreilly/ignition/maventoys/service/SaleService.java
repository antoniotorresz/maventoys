package com.oreilly.ignition.maventoys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.dto.SaleDTO;
import com.oreilly.ignition.maventoys.entity.Invoice;
import com.oreilly.ignition.maventoys.entity.Sale;
import com.oreilly.ignition.maventoys.mapper.SaleMapper;
import com.oreilly.ignition.maventoys.repository.InvoiceRepository;
import com.oreilly.ignition.maventoys.repository.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private InvoiceRepository invoiceRepository;

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

    public List<Object[]> findMostSoldProductsByCategory(Integer id) {
        return saleRepository.findMostSoldProductsByCategory(id);
    }

    public Sale saveSale(Sale sale, List<Invoice> _invoices) {
        System.out.println("Sale: " + sale.toString());
        System.out.println("Invoices: " + _invoices.toString());
        //_invoices.forEach(invoice -> invoice.getId().setSale(sale));
        for (Invoice invoice : _invoices) {
            invoice.getId().setSale(sale);
            invoice.toString();
        }
        Sale savedSale = saleRepository.save(sale);
        sale.setInvoices(invoiceRepository.saveAll(_invoices));
        return savedSale;
    }
}
