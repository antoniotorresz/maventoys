package com.oreilly.ignition.maventoys.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Store;
import com.oreilly.ignition.maventoys.service.StoreService;

@CrossOrigin
@RestController
@RequestMapping(value = "/stores", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController {
    /**
     * The service to handle the store operations.
     */
    private final StoreService storeService;

    /**
     * Creates a new instance of the controller.
     *
     * @param storeServiceParam the service to handle the store operations
     */
    public StoreController(final StoreService storeServiceParam) {
        this.storeService = storeServiceParam;
    }

    /**
     * Retrieves a list of stores.
     *
     * @return the list of stores
     */
    @GetMapping
    public ResponseEntity<CustomApiResponse> find() {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.find());
    }

    /**
     * Retrieves a store by its ID.
     *
     * @param storeId the ID of the store to retrieve
     * @return the store with the specified ID, or null if not found
     */
    @GetMapping("/{storeId}")
    public ResponseEntity<CustomApiResponse> findById(@PathVariable("storeId") final Integer storeId) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.findById(storeId));
    }

    /**
     * Saves a store.
     *
     * @param store the store to be saved
     * @return the saved store
     */
    @PostMapping
    public ResponseEntity<CustomApiResponse> save(@RequestBody final Store store) {
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.save(store));
    }

    /**
     * Deletes a store by its ID.
     *
     * @param storeId the ID of the store to delete
     * @return the deleted store
     */
    @DeleteMapping("/{storeId}")
    public ResponseEntity<CustomApiResponse> deleteById(@PathVariable("storeId") final Integer storeId) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.deleteById(storeId));
    }

    /**
     * Updates a store with the given storeId.
     *
     * @param storeId the ID of the store to update
     * @param store   the updated store object
     * @return a ResponseEntity containing the updated store if found, or the
     *         original store with HttpStatus.NOT_FOUND if not found
     */
    @PutMapping("{storeId}")
    public ResponseEntity<CustomApiResponse> update(@PathVariable("storeId") final Integer storeId,
            @RequestBody final Store store) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.update(storeId, store));
    }

    /**
     * Retrieves the employees of a store based on the given store ID.
     *
     * @param storeId the ID of the store
     * @return a ResponseEntity containing the employees of the store if found, or a
     *         ResponseEntity with a null body and NOT_FOUND status if the store is
     *         not found
     */
    @GetMapping("{storeId}/employees")
    public ResponseEntity<CustomApiResponse> findEmployees(@PathVariable("storeId") final Integer storeId) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.findEmployees(storeId));
    }

    /**
     * Retrieves the sales data for a specific store.
     *
     * @param storeId the ID of the store to retrieve sales data for
     * @return a ResponseEntity containing the sales data if the store exists, or a
     *         ResponseEntity with a null body and NOT_FOUND status if the store
     *         does not exist
     */
    @GetMapping("{storeId}/sales")
    public ResponseEntity<CustomApiResponse> findSales(@PathVariable("storeId") final Integer storeId) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getSales(storeId));
    }

    /**
     * Retrieves the revenue for a specific store.
     *
     * @param storeId the ID of the store
     * @return a ResponseEntity containing the store information and revenue if
     *         found, or a NOT_FOUND status if the store is not found
     */
    @GetMapping("{storeId}/revenue")
    public ResponseEntity<CustomApiResponse> findRevenue(@PathVariable("storeId") final Integer storeId) {
        return ResponseEntity.status(HttpStatus.OK).body(storeService.getRevenue(storeId));
    }
}
