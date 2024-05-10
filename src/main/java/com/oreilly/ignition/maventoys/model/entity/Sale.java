package com.oreilly.ignition.maventoys.model.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Data;

/**
 * Represents a sale of products.
 */
@Data
@Entity
@Table(name = "sales")
public class Sale {
    /**
     * The unique identifier for the sale.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The date of the sale.
     */
    private Date date;

    /**
     * The total amount of the sale.
     */
    private Double total;

    /**
     * The employee who made the sale.
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /**
     * The store where the sale was made.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    /**
     * The invoices associated with the sale.
     */
    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
    private Set<Invoice> invoices;

}
