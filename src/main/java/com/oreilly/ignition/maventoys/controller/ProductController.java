package com.oreilly.ignition.maventoys.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.ignition.maventoys.entity.Category;
import com.oreilly.ignition.maventoys.entity.Inventory;
import com.oreilly.ignition.maventoys.entity.Product;
import com.oreilly.ignition.maventoys.entity.Sale;
import com.oreilly.ignition.maventoys.service.ProductService;
import com.oreilly.ignition.maventoys.service.SaleService;
import com.oreilly.ignition.maventoys.service.CategoryService;
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
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @CrossOrigin
    public Object find(@RequestParam(value = "active", required = false) Boolean active,
            @RequestParam(value = "page", required = false, defaultValue = "-1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "-1") Integer limit,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) String category) {
        if (active == null) {
            if (page > -1 && limit > 0) {
                Pageable pageable = PageRequest.of(page, limit);
                return productService.findAll(pageable);
            }
            return productService.findAll(null);
        } else {
            return productService.findByActive(active ? true : false, null);
        }
    }

    // @GetMapping("/products")
    // public Object find(@RequestParam(value = "name", required = false) String name,
    //         @RequestParam(value = "category", required = false) String category,
    //         @RequestParam(value = "active", required = false) Boolean active,
    //         @RequestParam(value = "page", defaultValue = "0") int page,
    //         @RequestParam(value = "limit", defaultValue = "10") int limit) {
    //     Pageable pageable = PageRequest.of(page, limit);

    //     if (active != null) {
    //         return productService.findByActive(active ? 1 : 0, pageable);
    //     } else if (name != null && category != null) {
    //         return productService.findByNameAndCategory(name, category, pageable);
    //     } else if (name != null) {
    //         return productService.findByName(name, pageable);
    //     } else if (category != null) {
    //         return productService.findByCategory(category, pageable);
    //     } else {
    //         return productService.findAll(pageable);
    //     }
    // }

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
            product.setActive(true);
            return productService.save(product);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{productId}")
    @CrossOrigin
    public ResponseEntity<Product> deleteById(@PathVariable("productId") Integer productId) {
        Optional<Product> productOptional = productService.findById(productId);
        if (productOptional.isPresent()) {
            // we are doing logical delete, so we are just setting the active flag to 0
            Product product = productOptional.get();
            product.setActive(false);
            return ResponseEntity.ok(productService.save(product));
        } else {
            return ResponseEntity.status(404).build();
        }
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
                    put("sales", sales);
                }
            };
            return ResponseEntity.ok(inventoryPerProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/best-sellers")
    @CrossOrigin
    public ResponseEntity<HashMap<Object, Object>> getBestSellers(
            @RequestParam(value = "category", required = false) String category) {
        if (category == null) {
            List<Object[]> topSold = saleService.findMostSoldProducts();
            HashMap<Object, Object> bestSellers = new HashMap<>() {
                {
                    put("bestSellers", new ArrayList<>() {
                        {
                            for (Object[] productQuantity : topSold) {
                                add(new HashMap<>() {
                                    {
                                        put("product", productService.findById((Integer) productQuantity[0]).get());
                                        put("quantity", productQuantity[1]);
                                    }
                                });
                            }
                        }
                    });
                }
            };
            return ResponseEntity.ok(bestSellers);
        } else {
            Category categoryOptional = categoryService.findByName(category);
            if (categoryOptional != null) {
                List<Object[]> topSold = saleService.findMostSoldProductsByCategory(categoryOptional.getId());
                HashMap<Object, Object> bestSellers = new HashMap<>() {
                    {
                        put("bestSellers", new ArrayList<>() {
                            {
                                for (Object[] productQuantity : topSold) {
                                    add(new HashMap<>() {
                                        {
                                            put("product", productService.findById((Integer) productQuantity[0]).get());
                                            put("quantity", productQuantity[1]);
                                        }
                                    });
                                }
                            }
                        });
                    }
                };

                return ResponseEntity.ok(bestSellers);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<Object> bulkCostPriceUpdate(@RequestParam("csvFile") MultipartFile csvFile)
            throws FileNotFoundException, IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH_mm_ss");
        String pathToSave = "src/main/resources/static/bulk_updates/product_bulk_" + currentTime.format(formatter)
                + ".csv";
        Files.write(Paths.get(pathToSave), csvFile.getBytes());
        int count;
        
        try (FileReader fileReader = new FileReader(pathToSave);
                CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(fileReader)) {
            List<CSVRecord> records = csvParser.getRecords();
            count = records.size();
            for (CSVRecord row : records) {
                // Access each record's values using the header names
                System.out.println("Updating product " + row.get("id") + " to price " + row.get("price") + " and cost "
                        + row.get("cost"));
                productService.updatePriceAndCost(Integer.parseInt(row.get("id")),
                        Double.parseDouble(row.get("price")), Double.parseDouble(row.get("cost")));
            }
            System.out.println("Finished updating " + count + " products");
            return ResponseEntity.ok(Collections.singletonMap("message", count + " products updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Error updating products"));
        }
    }
}
