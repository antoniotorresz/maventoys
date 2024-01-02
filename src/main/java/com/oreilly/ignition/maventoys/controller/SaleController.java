package com.oreilly.ignition.maventoys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.dto.ProductQuantity;
import com.oreilly.ignition.maventoys.dto.SaleDTO;
import com.oreilly.ignition.maventoys.entity.Invoice;
import com.oreilly.ignition.maventoys.entity.InvoiceId;
import com.oreilly.ignition.maventoys.entity.Product;
import com.oreilly.ignition.maventoys.entity.Sale;
import com.oreilly.ignition.maventoys.service.EmployeeService;
import com.oreilly.ignition.maventoys.service.ProductService;
import com.oreilly.ignition.maventoys.service.SaleService;
import com.oreilly.ignition.maventoys.service.StoreService;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private ProductService productService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Sale> find() {
        return saleService.find();
    }

    @GetMapping("/{saleId}")
    public Sale findById(@PathVariable("saleId") Integer saleId) {
        return saleService.findById(saleId).orElse(null);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SaleDTO saleDto) {
        Sale sale = new Sale();
        Set<Product> products = new HashSet<Product>();
        HashMap<Product, Integer> productQuantity = new HashMap<Product, Integer>();
        Double total = 0.0, subtotal = 0.0;
        List<Invoice> invoices = new ArrayList<Invoice>();

        sale.setDate(new Date());
        if (!(storeService.findById(saleDto.getStoreId()).isPresent())
                || !(employeeService.findById(saleDto.getEmployeeId()).isPresent())) {
            return ResponseEntity.badRequest().body("Invalid store or employee");
        }

        sale.setStore(storeService.findById(saleDto.getStoreId()).get());
        sale.setEmployee(employeeService.findById(saleDto.getEmployeeId()).get());

        for (ProductQuantity productRecord : saleDto.getProductQuantity()) {
            Optional<Product> productOptional = productService.findById(productRecord.getProductId());
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                products.add(product);
                subtotal = product.getPrice() * productRecord.getQuantity();
                //public Invoice(InvoiceId id, Integer quantity, Double subtotal, Float discount, Byte status)
                invoices.add(new Invoice(new InvoiceId(null, product), productRecord.getQuantity(), subtotal, 0.0f, (byte) 1));
                //invoices.add(new Invoice(productRecord.getQuantity(), subtotal, 0.0f));
                productQuantity.put(product, productRecord.getQuantity());
                total += subtotal;
            }
        }

        sale.setTotal(total);
        saleService.saveSale(sale, invoices);
        return new ResponseEntity<>(new HashMap<>() {
            {
                //put("sale", saleService.saveSale(sale, invoices));
                put("generatedInvoice", invoices);
            }
        }, null, 201);
    }
}
