package com.oreilly.ignition.maventoys.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oreilly.ignition.maventoys.model.entity.Product;
import com.oreilly.ignition.maventoys.model.entity.Sale;

/**
 * This interface represents a repository for managing products.
 * It extends the JpaRepository interface, providing CRUD operations for the
 * Product entity.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Updates the price and cost of a product with the given ID.
     *
     * @param productId The ID of the product to update.
     * @param price     The new price of the product.
     * @param cost      The new cost of the product.
     */
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = :price, p.cost = :cost WHERE p.id = :productId")
    void updatePriceAndCost(@Param("productId") Integer productId, @Param("price") Double price,
            @Param("cost") Double cost);

    /**
     * Retrieves a list of products based on the given list of IDs.
     *
     * @param ids The list of IDs to search for.
     * @return A list of products matching the given IDs.
     */
    List<Product> findByIdIn(List<Integer> ids);

    /**
     * Retrieves a list of products with their corresponding stock on hand, filtered
     * by the specified stock threshold.
     *
     * @param stock The stock threshold to filter the products by.
     * @return A list of Object arrays containing the product ID and stock on hand
     *         for each product.
     */
    @Query(value = "SELECT p.id AS id, i.stock_on_hand AS stockOnHand FROM products p" +
            "INNER JOIN inventory i ON p.id = i.product_id" +
            "WHERE i.stock_on_hand < :stock ORDER BY i.stock_on_hand DESC", nativeQuery = true)
    List<Object[]> findProductsByStock(@Param("stock") Integer stock);

    /**
     * Returns the total number of active products in the repository.
     *
     * @return the total number of active products
     */
    @Query(value = "SELECT COUNT(*) FROM products WHERE active = 1", nativeQuery = true)
    Integer findTotalActiveProducts();

    /**
     * Retrieves all sales with their associated invoices and products for a given
     * product ID.
     *
     * @param productId the ID of the product
     * @return a list of Sale objects
     */
    @Query(value = "SELECT s.* FROM sales s INNER JOIN invoices i ON i.sales_id = s.id" +
            "INNER JOIN products p ON p.id = i.product_id WHERE p.id = :productId", nativeQuery = true)
    List<Sale> findAllSalesWithInvoicesAndProducts(@Param("productId") Integer productId);

    /**
     * Retrieves the most sold products, limited to the top 5.
     *
     * @return a list of Object arrays containing the product ID and the total
     *         quantity sold
     */
    @Query(value = "SELECT i.product_id, sum(quantity) AS total_sold FROM invoices i " +
            "INNER JOIN sales s ON i.sales_id = s.id GROUP BY i.product_id " +
            "ORDER BY total_sold DESC LIMIT 6", nativeQuery = true)
    List<Object[]> findMostSoldProducts();

    /**
     * Retrieves the most sold products in a specific category, limited to the top
     * 5.
     *
     * @param categoryId the ID of the category
     * @return a list of Object arrays containing the product ID and the total
     *         quantity sold
     */
    @Query(value = "SELECT i.product_id, sum(quantity) AS total_sold FROM invoices i" +
            "INNER JOIN sales s ON i.sales_id = s.id INNER JOIN products p ON i.product_id = p.id" +
            "WHERE p.category_id = :categoryId GROUP BY i.product_id ORDER BY total_sold DESC LIMIT 5",
            nativeQuery = true)
    List<Object[]> findMostSoldProductsByCategory(@Param("categoryId") Integer categoryId);

}
