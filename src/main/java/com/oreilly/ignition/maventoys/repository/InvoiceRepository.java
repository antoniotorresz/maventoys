package com.oreilly.ignition.maventoys.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oreilly.ignition.maventoys.model.entity.Invoice;

/**
 * This interface represents a repository for managing invoices.
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    /**
     * Retrieves a list of objects representing invoices associated with a specific
     * sale ID.
     * @param saleId The ID of the sale.
     * @return A list of objects representing invoices.
     */
    @Query(value = "SELECT * FROM invoices WHERE sales_id = :saleId", nativeQuery = true)
    List<Object[]> findBySaleId(@Param("saleId") Integer saleId);
}
