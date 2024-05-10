package com.oreilly.ignition.maventoys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oreilly.ignition.maventoys.model.entity.Category;
import com.oreilly.ignition.maventoys.model.entity.Product;

/**
 * This interface represents a repository for managing Category entities.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Finds a category by its name.
     *
     * @param name the name of the category
     * @return the found category, or null if not found
     */
    Optional<Category> findByName(String name);

    /**
     * Finds all products belonging to a specific category.
     *
     * @param categoryId the ID of the category
     * @return a list of products belonging to the category
     */
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findProducts(@Param("categoryId") Integer categoryId);
}
