package com.oreilly.ignition.maventoys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.ignition.maventoys.entity.Invoice;
import com.oreilly.ignition.maventoys.entity.InvoiceId;

public interface InvoiceRepository extends JpaRepository<Invoice, InvoiceId>{
    
}
