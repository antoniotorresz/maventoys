package com.oreilly.ignition.maventoys.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * Represents an inventory item.
 */
@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    /**
     * The ID of the inventory item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The product associated with the inventory item.
     */
    @ManyToOne
    private Product product;

    /**
     * The stock on hand for the inventory item.
     */
    private Integer stockOnHand;

    /**
     * Default constructor.
     */
    public Inventory() {
    }

    /**
     * Constructor that initializes the ID, product, and stock on hand.
     *
     * @param idParam          The ID of the inventory item.
     * @param productParam     The product associated with the inventory item.
     * @param stockOnHandParam The stock on hand for the inventory item.
     */
    public Inventory(final Integer idParam, final Product productParam, final Integer stockOnHandParam) {
        this.id = idParam;
        this.stockOnHand = stockOnHandParam;
    }

}
