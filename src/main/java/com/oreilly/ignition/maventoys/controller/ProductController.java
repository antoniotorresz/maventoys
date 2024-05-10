package com.oreilly.ignition.maventoys.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.oreilly.ignition.maventoys.service.ProductService;
import com.oreilly.ignition.maventoys.service.SaleService;
import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Product;
import com.oreilly.ignition.maventoys.service.CategoryService;
import com.oreilly.ignition.maventoys.service.InventoryService;

@CrossOrigin
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    /**
     * The service to handle the product operations.
     */
    private final ProductService productService;
    /**
     * The service to handle the inventory operations.
     */
    private final InventoryService inventoryService;
    /**
     * The service to handle the sale operations.
     */
    private final SaleService saleService;
    /**
     * The service to handle the category operations.
     */
    private final CategoryService categoryService;

    /**
     * Constructs a new ProductController with the specified services.
     *
     * @param productServiceParam   the ProductService to handle product operations
     * @param inventoryServiceParam the InventoryService to handle inventory
     *                              operations
     * @param saleServiceParam      the SaleService to handle sale operations
     * @param categoryServiceParam  the CategoryService to handle category
     *                              operations
     */
    @Autowired
    public ProductController(final ProductService productServiceParam, final InventoryService inventoryServiceParam,
            final SaleService saleServiceParam, final CategoryService categoryServiceParam) {
        this.productService = productServiceParam;
        this.inventoryService = inventoryServiceParam;
        this.saleService = saleServiceParam;
        this.categoryService = categoryServiceParam;
    }

    /**
     * Retrieves products based on the specified parameters.
     *
     * @param active   the active status of the products (optional)
     * @param page     the page number for pagination (optional, default: 0)
     * @param limit    the maximum number of products per page (optional, default:
     *                 0)
     * @param name     the name of the products (optional)
     * @param category the category of the products (optional)
     * @param stock    the minimum stock quantity of the products (optional,
     *                 default: 0)
     * @return an object containing the retrieved products
     */
    @GetMapping
    public ResponseEntity<CustomApiResponse> find(
            @RequestParam(value = "active", required = false) final Boolean active,
            @RequestParam(value = "page", required = false, defaultValue = "0") final Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "0") final Integer limit,
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "category", required = false) final String category,
            @RequestParam(value = "low", required = false, defaultValue = "0") final Integer stock) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.find(page, limit, name, category, stock, active));
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID of the product to retrieve
     * @return a ResponseEntity containing the product if found, or a not found
     *         response if not found
     */
    @GetMapping(value = "/{productId}")
    public ResponseEntity<CustomApiResponse> findById(@PathVariable("productId") final Integer productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findById(productId));
    }

    /**
     * Creates a new product.
     *
     * @param product the product to be created
     * @return the created product
     */
    @PostMapping
    public ResponseEntity<CustomApiResponse> create(@RequestBody final Product product) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.save(product));
    }

    /**
     * Deletes a product by its ID.
     *
     * @param productId the ID of the product to be deleted
     * @return a ResponseEntity containing the deleted product if it exists, or a
     *         404 status if it does not exist
     */
    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<CustomApiResponse> deleteById(@PathVariable("productId") final Integer productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.deleteById(productId));
    }

    /**
     * Updates a product with the given ID.
     *
     * @param productId The ID of the product to update.
     * @param product   The updated product information.
     * @return The updated product.
     */
    @PutMapping(value = "/{productId}")
    public ResponseEntity<CustomApiResponse> update(@PathVariable("productId") final Integer productId,
            @RequestBody final Product product) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.update(productId, product));
    }

    /**
     * Updates the price and cost of a product.
     *
     * @param productId the ID of the product to update
     * @param product   the updated product information
     * @return the updated product
     */
    @PatchMapping(value = "/{productId}")
    public ResponseEntity<CustomApiResponse> updatePriceCost(@PathVariable("productId") final Integer productId,
            @RequestBody final Product product) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.updatePriceAndCost(productId, product));
    }

    /**
     * Retrieves the inventory information for a given product.
     *
     * @param productId the ID of the product
     * @return a ResponseEntity containing the inventory information
     */
    @GetMapping(value = "/{productId}/inventory")
    public ResponseEntity<Object> getInventory(@PathVariable("productId") final Integer productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findInventoriesByProductId(productId));
    }

    /**
     * Retrieves the sales information for a specific product.
     *
     * @param productId the ID of the product
     * @return a ResponseEntity containing the sales information
     */
    @GetMapping(value = "/{productId}/sales")
    public ResponseEntity<CustomApiResponse> getSales(@PathVariable("productId") final Integer productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findSalesByProductId(productId));
    }

    /**
     * Retrieves the best-selling products based on the specified category.
     *
     * @param category the category of products to filter by (optional)
     * @return a ResponseEntity containing the best-selling products and their
     *         quantities
     */
    @GetMapping(value = "/best-sellers")
    public ResponseEntity<CustomApiResponse> getBestSellers(
            @RequestParam(value = "category", required = false) final String category) {
        if (category == null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productService.findMostSoldProducts());
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productService.findMostSoldProductsByCategory(category));
        }
    }

    /**
     * Updates the cost price of multiple products using a CSV file.
     * @param csvFile the CSV file containing the product data
     * @return a ResponseEntity object with the update status message
     * @throws FileNotFoundException if the CSV file is not found
     * @throws IOException           if an I/O error occurs while reading the CSV
     *                               file
     */
    @PutMapping(value = "/bulk-update")
    public ResponseEntity<Object> bulkCostPriceUpdate(@RequestParam("csvFile") final MultipartFile csvFile)
            throws FileNotFoundException, IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.bulkCostPriceUpdate(csvFile));
    }

}
