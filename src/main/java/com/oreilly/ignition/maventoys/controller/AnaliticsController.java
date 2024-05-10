package com.oreilly.ignition.maventoys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.service.AnaliticsService;

@CrossOrigin
@RestController
@RequestMapping(value = "/analitics", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnaliticsController {
    /**
     * The service to handle the analytics operations.
     */
    private final AnaliticsService analiticsService;

    /**
     * Creates a new instance of the controller.
     *
     * @param analiticsServiceParam the service to handle the analytics operations.
     */
    @Autowired
    public AnaliticsController(final AnaliticsService analiticsServiceParam) {
        this.analiticsService = analiticsServiceParam;
    }

    /**
     * Retrieves the total number of active products.
     *
     * @return An object containing the total number of active products.
     */
    @GetMapping("/get-total-active-products")
    public ResponseEntity<CustomApiResponse> getTotalActiveProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getTotalActiveProducts());
    }
    //FAILS FAILS FAILS
    /**
     * Retrieves the best-selling products.
     *
     * @return a list of best-selling products, where each product is represented as
     *         a map with "productId" and "quantity" keys.
     */
    @GetMapping("/best-selling-products")
    public ResponseEntity<CustomApiResponse> getBestSellingProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getBestSellingProducts());
    }

    //FAILS FAILS FAILS
    /**
     * Retrieves the stock of products based on the specified value.
     *
     * @param stock the minimum stock value to filter the products (optional,
     *              default value is 0)
     * @return an Object containing the products with stock greater than or equal to
     *         the specified value
     */
    @GetMapping("/get-stock")
    public ResponseEntity<CustomApiResponse> getStock(
            @RequestParam(value = "low", required = false, defaultValue = "10") final Integer stock) {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getStock(stock));
    }

    /**
     * Retrieves the total sales.
     *
     * @return An object containing the total sales.
     */
    @GetMapping("/get-total-sales")
    public ResponseEntity<CustomApiResponse> getTotalSales() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getTotalSales());
    }

    /**
     * Retrieves a list of employees with the most sales.
     *
     * @return A list of employees with their employee ID, full name, and total
     *         sales.
     */
    @GetMapping("/get-employees-with-most-sales")
    public ResponseEntity<CustomApiResponse> getEmployeesWithMostSales() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getEmployeesWithMostSales());
    }

    /**
     * Retrieves the total revenue.
     *
     * @return An object containing the total revenue.
     */
    @GetMapping("/get-total-revenue")
    public ResponseEntity<CustomApiResponse> getTotalRevenue() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getTotalRevenue());
    }

    //FAILS FAILS FAILS
    /**
     * Retrieves the most sold categories.
     *
     * @return a list of objects representing the most sold categories, each
     *         containing the category ID, name, and count.
     */
    @GetMapping("/get-most-sold-categories")
    public ResponseEntity<CustomApiResponse> getMostSoldCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getMostSoldCategories());
    }

    /**
     * Retrieves the stores information.
     *
     * @return an Object containing the total number of stores
     */
    @GetMapping("/get-stores")
    public ResponseEntity<CustomApiResponse> getStores() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getStores());
    }

    /**
     * Retrieves the total number of items sold.
     *
     * @return An object containing the total number of items sold.
     */
    @GetMapping("/get-total-items-sold")
    public ResponseEntity<CustomApiResponse> getTotalItemsSold() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getTotalItemsSold());
    }

    //FAILS FAILS FAILS
    /**
     * Retrieves the revenue per store.
     *
     * @return An object representing the revenue per store.
     */
    @GetMapping("/get-revenue-per-store")
    public ResponseEntity<CustomApiResponse> getRevenueByStore() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getRevenueByStore());
    }

    //FAILS FAILS FAILS
    /**
     * Retrieves the last invoices based on the specified limit.
     *
     * @param limit the maximum number of invoices to retrieve (default: 50)
     * @return a list of objects representing the last invoices
     */
    @GetMapping("/get-last-invoices")
    public ResponseEntity<CustomApiResponse> getLastInvoices(
            @RequestParam(value = "limit", required = false, defaultValue = "50") final Integer limit) {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getLastInvoices(limit));
    }

    /**
     * Retrieves the total number of employees.
     *
     * @return An object containing the total number of employees.
     */
    @GetMapping("/get-total-employees")
    public ResponseEntity<CustomApiResponse> getTotalEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(analiticsService.getTotalEmployees());
    }
}
