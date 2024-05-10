package com.oreilly.ignition.maventoys.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Category;
import com.oreilly.ignition.maventoys.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;

/**
 * This class represents a service for managing categories.
 */
@Service
public class CategoryService {
    /**
     * The repository for managing categories.
     */
    private final CategoryRepository categoryRepository;

    /**
     * Constructs a CategoryService with the specified CategoryRepository.
     *
     * @param categoryRepo the CategoryRepository to be used
     */
    @Autowired
    public CategoryService(final CategoryRepository categoryRepo) {
        this.categoryRepository = categoryRepo;
    }

    /**
     * Retrieves all categories.
     *
     * @return a list of all categories
     */
    public CustomApiResponse find() {
        try {
            List<Category> categories = categoryRepository.findAll();
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Fetched all categories succesfully",
                    categories);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while fetching categories", null);
        }
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to retrieve
     * @return an optional containing the category, or an empty optional if not
     *         found
     */
    public CustomApiResponse findById(final Integer id) {
        try {
            Category category = categoryRepository.findById(Objects.requireNonNull(id)).orElseThrow(
                    () -> new EntityNotFoundException("Category not found with id: " + id));
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Category found", category);
        } catch (EntityNotFoundException entityNotFoundException) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), entityNotFoundException.getMessage(),
                    null);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while fetching category", null);
        }
    }

    /**
     * Saves a category.
     *
     * @param category the category to save
     * @return the saved category
     */
    public CustomApiResponse save(@NonNull final Category category) {
        try {
            Category savedCategory = categoryRepository.save(category);
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Category saved successfully",
                    savedCategory);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while saving category", null);
        }
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     * @return the deleted category
     */
    public CustomApiResponse deleteById(@NonNull final Integer id) {
        try {
            Category category = categoryRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Category not found with id: " + id));
            category.setActive(false);
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Category deleted successfully",
                    categoryRepository.save(category));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(),
                    "Category is not present.", null);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while deleting category", null);
        }
    }

    /**
     * Retrieves all products belonging to a category.
     *
     * @param categoryId the ID of the category
     * @return a list of products belonging to the category
     */
    public CustomApiResponse findProducts(@NonNull final Integer categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).orElseThrow(
                    () -> new EntityNotFoundException("Category not found with id: " + categoryId));
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Fetched all products for category successfully",
                    categoryRepository.findProducts(category.getId()));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(),
                    "Category is not present.", null);
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error ocurred while fetching products for category", null);
        }
    }
}
