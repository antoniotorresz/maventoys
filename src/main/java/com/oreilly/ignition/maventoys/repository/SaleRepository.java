package com.oreilly.ignition.maventoys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.oreilly.ignition.maventoys.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    //get all sales by product id
    @Query(value = "SELECT s.* FROM sales s INNER JOIN invoices i ON i.sales_id = s.id INNER JOIN products p ON p.id = i.product_id WHERE p.id = :productId", nativeQuery = true)
    List<Sale> findAllSalesWithInvoicesAndProducts(@Param("productId") Integer productId);
    
    //get most sold products, limit 5
    @Query(value = "SELECT i.product_id, sum(quantity) AS total_sold FROM invoices i INNER JOIN sales s ON i.sales_id = s.id GROUP BY i.product_id ORDER BY total_sold DESC LIMIT 5", nativeQuery = true)
    List<Object[]> findMostSoldProducts();

}
