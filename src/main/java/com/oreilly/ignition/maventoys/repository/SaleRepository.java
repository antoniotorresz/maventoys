package com.oreilly.ignition.maventoys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.oreilly.ignition.maventoys.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    //@Query("SELECT s FROM Sale s JOIN s.products p WHERE p.id = :productId")
    //@Query(value = "SELECT i.product_id AS productId, sum(i.quantity) AS totalSold FROM invoices i INNER JOIN sales s ON i.sales_id = s.id GROUP BY i.product_id ORDER BY totalSold DESC", nativeQuery = true)
    // List<ProductSales> findTotalQuantitySoldForEachProduct();

    // //@Query("SELECT s FROM Sale s JOIN s.invoices i JOIN i.product p WHERE p.id = :productId")

    // List<Sale> findByProductId(@Param("productId") Integer productId);

    // @Query(value = "SELECT new com.oreilly.ignition.dto.ProductSales(i.product_id, sum(i.quantity)) FROM invoices i INNER JOIN sales s ON i.sales_id = s.id GROUP BY i.product_id ORDER BY sum(i.quantity) DESC", nativeQuery = true)
    // List<ProductSales> findTotalQuantitySoldForEachProduct();

    // @Query(value = "SELECT i.product_id, sum(i.quantity) AS total_sold FROM invoices i INNER JOIN sales s ON i.sales_id = s.id GROUP BY i.product_id ORDER BY total_sold DESC", nativeQuery = true)
    // List<ProductSales> findTotalQuantitySoldForEachProduct();

    // @Query(value = "SELECT i.product_id, sum(i.quantity) AS total_sold FROM invoices i INNER JOIN sales s ON i.sales_id = s.id GROUP BY i.product_id ORDER BY total_sold DESC", nativeQuery = true)
    // @SqlResultSetMapping(name = "ProductSalesMapping")
    // List<ProductSales> findTotalQuantitySoldForEachProduct();

    // @Query(nativeQuery = true, name = "ProductSalesMapping")
    // List<ProductSales> findTotalQuantitySoldForEachProduct();

    // @Query("SELECT s FROM Sale s JOIN s.invoices i JOIN i.product p")
    // List<Sale> findAllSalesWithInvoicesAndProducts();

    @Query(value = "SELECT s.* FROM sales s INNER JOIN invoices i ON i.sales_id = s.id INNER JOIN products p ON p.id = i.product_id WHERE p.id = :productId", nativeQuery = true)
    List<Sale> findAllSalesWithInvoicesAndProducts(@Param("productId") Integer productId);
    

}
