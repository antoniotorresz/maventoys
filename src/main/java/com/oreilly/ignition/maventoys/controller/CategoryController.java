package com.oreilly.ignition.maventoys.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Category;
import com.oreilly.ignition.maventoys.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin
@RestController
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    /**
     * The service to handle the category operations.
     */
    private final CategoryService categoryService;

    /**
     * Creates a new instance of the controller.
     *
     * @param categoryServiceParam the service to handle the category operations
     */
    @Autowired
    public CategoryController(final CategoryService categoryServiceParam) {
        this.categoryService = categoryServiceParam;
    }

    /**
     * Retrieves a list of categories.
     *
     * @return the list of categories
     */
    @GetMapping
    @Operation(summary = "Retrieves a list of categories")
    public ResponseEntity<CustomApiResponse> find() {
        CustomApiResponse response = categoryService.find();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param categoryId the ID of the category to retrieve
     * @return the category with the specified ID, or null if not found
     */
    @GetMapping(value = "/{categoryId}")
    @Operation(summary = "Retrieves a category by its ID")
    public ResponseEntity<CustomApiResponse> findById(@PathVariable("categoryId") final Integer categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(categoryId));
    }

    /**
     * Saves a category.
     *
     * @param category The category to be saved.
     * @return The saved category.
     */
    @PostMapping
    @Operation(summary = "Saves a category")
    public ResponseEntity<CustomApiResponse> save(@RequestBody final Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    /**
     * Updates a category with the given category ID.
     *
     * @param categoryId The ID of the category to be updated.
     * @param category   The updated category object.
     * @return ResponseEntity<Object> The response entity containing the updated
     *         category if found, or the original category with a NOT_FOUND status
     *         if not found.
     */
    @PutMapping(value = "/{categoryId}")
    @Operation(summary = "Updates a category with the given category ID")
    public ResponseEntity<Object> update(@PathVariable("categoryId") final Integer categoryId,
            final Category category) {
        if (categoryService.findById(categoryId).getData() != null) {
            category.setId(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(category));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(category);
    }

    /**
     * Updates a category with the specified ID using the PATCH method.
     *
     * @param categoryId The ID of the category to be updated.
     * @param category   The updated category object.
     * @return ResponseEntity<Object> The response entity containing the updated
     *         category if found, or the original category with a NOT_FOUND status.
     */
    @PatchMapping(value = "/{categoryId}")
    @Operation(summary = "Updates a category with the specified ID using the PATCH method")
    public ResponseEntity<Object> patch(@PathVariable("categoryId") final Integer categoryId, final Category category) {
        if (categoryService.findById(categoryId).getData() != null) {
            category.setId(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(category));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(category);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param categoryId the ID of the category to be deleted
     * @return a ResponseEntity containing the response of the delete operation
     */
    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Deletes a category by its ID")
    public ResponseEntity<CustomApiResponse> deleteById(@PathVariable("categoryId") final Integer categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteById(categoryId));
    }

    /**
     * Retrieves the products associated with a given category.
     *
     * @param categoryId the ID of the category
     * @return a ResponseEntity containing the products found, or a NOT_FOUND status
     *         if the category does not exist
     */
    @GetMapping(value = "/{categoryId}/products")
    @Operation(summary = "Retrieves the products associated with a given category")
    public ResponseEntity<CustomApiResponse> findProducts(@PathVariable("categoryId") final Integer categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findProducts(categoryId));
    }
}
