package com.oreilly.ignition.maventoys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.entity.Inventory;
import com.oreilly.ignition.maventoys.entity.Product;
import com.oreilly.ignition.maventoys.entity.Sale;
import com.oreilly.ignition.maventoys.service.ProductService;
import com.oreilly.ignition.maventoys.service.SaleService;
import com.oreilly.ignition.maventoys.service.InventoryService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private SaleService saleService;

    @GetMapping
    @CrossOrigin
    public List<Product> find(@RequestParam(value = "active", required = false) Boolean active) {
        if (active == null) {
            return productService.findAll();
        } else {
            return productService.findByActive(active ? 1 : 0);
        }
    }

    @GetMapping("/{productId}")
    @CrossOrigin
    public ResponseEntity<Product> findById(@PathVariable("productId") Integer productId) {
        return productService.findById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @CrossOrigin
    public Product create(@RequestBody Product product) {
        if (product != null) {
            product.setCreationDate(new Date());
            product.setActive(1);
            return productService.save(product);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{productId}")
    @CrossOrigin
    public void deleteById(@PathVariable("productId") Integer productId) {
        productService.deleteById(productId);
    }

    @PutMapping("/{productId}")
    @CrossOrigin
    public Product update(@PathVariable("productId") Integer productId, @RequestBody Product product) {
        Product productToUpdate = productService.findById(productId).orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setCost(product.getCost());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setCategory(product.getCategory());
            return productService.save(productToUpdate);
        } else {
            return null;
        }
    }

    @PatchMapping("/{productId}")
    @CrossOrigin
    public Product updatePriceCost(@PathVariable("productId") Integer productId, @RequestBody Product product) {
        Product productToUpdate = productService.findById(productId).orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setCost(product.getCost());
            return productService.save(productToUpdate);
        } else {
            return null;
        }
    }

    @GetMapping("/{productId}/inventory")
    @CrossOrigin
    public ResponseEntity<HashMap<Object, Object>> getInventory(@PathVariable("productId") Integer productId) {
        Optional<Product> productOptional = productService.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            List<Inventory> inventories = inventoryService.findByProductId(product.getId());
            HashMap<Object, Object> inventoryPerProduct = new HashMap<>() {
                {
                    put("product", product);
                    put("totalStock", inventories.stream().mapToInt(Inventory::getStockOnHand).sum());
                    put("inventory", new ArrayList<>() {
                        {
                            for (Inventory inventory : inventories) {
                                add(new HashMap<>() {
                                    {
                                        put("id", inventory.getId());
                                        put("stockOnHand", inventory.getStockOnHand());
                                    }
                                });
                            }
                        }
                    });
                }
            };
            return ResponseEntity.ok(inventoryPerProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{productId}/sales")
    @CrossOrigin
    public ResponseEntity<HashMap<Object, Object>> getSales(@PathVariable("productId") Integer productId) {
        Optional<Product> productOptional = productService.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            List<Sale> sales = saleService.findByProductId(product.getId());
            HashMap<Object, Object> inventoryPerProduct = new HashMap<>() {
                {
                    put("product", product);
                    put("timesSold", sales.size());
                    put("totalEarn", sales.stream().mapToDouble(Sale::getTotal).sum());
                    put("sales", sales);
                }
            };
            return ResponseEntity.ok(inventoryPerProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
