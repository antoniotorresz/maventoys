package com.oreilly.ignition.maventoys.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.exception.EntityNotFoundException;
import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Store;
import com.oreilly.ignition.maventoys.repository.StoreRepository;

import lombok.NonNull;

/**
 * This class represents a service for managing stores.
 */
@Service
public class StoreService {
    /**
     * The repository for managing store data.
     */
    private final StoreRepository storeRepository;


    /**
     * Constructs a new StoreService with the specified StoreRepository.
     * @param storeRepo the StoreRepository to be used
     */
    @Autowired
    public StoreService(final StoreRepository storeRepo) {
        this.storeRepository = storeRepo;
    }

    /**
     * Retrieves all stores.
     * @return a list of all stores
     */
    public CustomApiResponse find() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Stores fetched successfully",
                    storeRepository.findAll());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }

    /**
     * Retrieves a store by its ID.
     * @param id the ID of the store to retrieve
     * @return an Optional containing the store, or an empty Optional if the store
     *         does not exist
     */
    public CustomApiResponse findById(@NonNull final Integer id) {
        try {
            Store store = storeRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Store not found for ID: " + id));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Store fetched successfully", store);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        }
    }

    /**
     * Saves a store.
     * @param store the store to save
     * @return the saved store
     */
    public CustomApiResponse save(@NonNull final Store store) {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Store saved successfully",
                    storeRepository.save(store));
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.toString());
        }
    }

    /**
     * Updates a store with the specified ID.
     * @param storeId the ID of the store to update
     * @param store the updated store object
     * @return a CustomApiResponse indicating the result of the update operation
     */
    public final CustomApiResponse update(@NonNull final Integer storeId, @NonNull final Store store) {
        try {
            Store existingStore = storeRepository.findById(storeId).orElseThrow(
                    () -> new EntityNotFoundException("Store not found for ID: " + storeId));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Store updated successfully",
                    storeRepository.save(existingStore));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        }
    }

    /**
     * Deletes a store by its ID.
     * @param id the ID of the store to delete
     * @return a CustomApiResponse indicating the result of the delete operation
     */
    public CustomApiResponse deleteById(@NonNull final Integer id) {
        try {
            Store store = storeRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Store not found for ID: " + id));
            store.setActive(false);
            storeRepository.save(store);
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Store deleted successfully", store);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        }
    }

    /**
     * Retrieves the sales for a specific store.
     * @param storeId the ID of the store
     * @return the sales for the store
     */
    public CustomApiResponse getSales(@NonNull final Integer storeId) {
        try {
            Store store = storeRepository.findById(storeId).orElseThrow(
                    () -> new EntityNotFoundException("Store not found for ID: " + storeId));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Sales fetched successfully",
                    storeRepository.findSales(store.getId()));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.toString());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.toString());
        }
    }

    /**
     * Retrieves the revenue for a specific store.
     * @param storeId the ID of the store
     * @return the revenue for the store
     */
    public CustomApiResponse getRevenue(final Integer storeId) {
        try {
            Store store = storeRepository.findById(storeId).orElseThrow(
                    () -> new EntityNotFoundException("Store not found for ID: " + storeId));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Revenue fetched successfully",
                    new HashMap<Object, Object>() {
                        {
                            put("store", store);
                            put("revenue", storeRepository.getRevenue(store.getId()));
                        }
                    });
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        }
    }

    /**
     * Retrieves the total number of stores.
     * @return the total number of stores
     */
    public Integer getTotalStores() {
        return storeRepository.getTotalStores();
    }

    /**
     * Retrieves the total revenue for all stores.
     * @return the total revenue for all stores
     */
    public List<Object[]> getRevenueByStore() {
        return storeRepository.getRevenueByStore();
    }

    /**
     * Retrieves the employees for a specific store.
     * @param storeId the ID of the store
     * @return the employees for the store
     */
    public CustomApiResponse findEmployees(final Integer storeId) {
        try {
            Store store = storeRepository.findById(storeId).orElseThrow(
                    () -> new EntityNotFoundException("Store not found for ID: " + storeId));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Employees fetched successfully",
                    store.getEmployees());
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        }
    }
}
