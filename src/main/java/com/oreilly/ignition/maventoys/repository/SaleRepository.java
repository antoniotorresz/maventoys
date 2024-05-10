package com.oreilly.ignition.maventoys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oreilly.ignition.maventoys.model.entity.Sale;

/**
 * The SaleRepository interface provides methods for accessing and manipulating
 * sales data in the repository.
 */
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    /**
     * Retrieves the total number of sales.
     *
     * @return the total number of sales
     */
    @Query(value = "SELECT COUNT(*) FROM sales", nativeQuery = true)
    Integer findTotalSales();

    /**
     * Retrieves the total revenue from all sales.
     *
     * @return the total revenue
     */
    @Query(value = "SELECT SUM(total) FROM sales", nativeQuery = true)
    Double getTotalRevenue();

    /**
     * Retrieves the categories with the highest number of sales.
     *
     * @return a list of Object arrays containing the category ID, name, and the
     *         count of sales
     */
    @Query(value = "SELECT c.id, c.name, COUNT(*) AS categoryCount FROM invoices i " +
            "INNER JOIN products p ON i.product_id = p.id" +
            "INNER JOIN categories c ON c.id = p.category_id" +
            "GROUP BY c.id, c.name ORDER BY categoryCount DESC", nativeQuery = true)
    List<Object[]> findMostSoldCategories();

    /**
     * Retrieves the total number of items sold.
     *
     * @return the total number of items sold
     */
    @Query(value = "SELECT SUM(quantity) FROM invoices", nativeQuery = true)
    Integer findTotalItemsSold();

    /**
     * Retrieves the last invoices up to a specified limit.
     *
     * @param limit the maximum number of invoices to retrieve
     * @return a list of Object arrays containing the invoice ID, product ID, and
     *         quantity
     */
    @Query(value = "SELECT id AS invoiceId, product_id, quantity, sales_id" +
            "FROM invoices ORDER BY invoiceId DESC LIMIT :limit ", nativeQuery = true)
    List<Object[]> findLastInvoices(@Param("limit") Integer limit);
}
