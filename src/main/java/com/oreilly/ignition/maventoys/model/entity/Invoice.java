package com.oreilly.ignition.maventoys.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents an invoice for a sale of a product.
 */
@Data
@Entity
@Table(name = "invoices")
public class Invoice {

    /**
     * The unique identifier for the invoice.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The sale associated with the invoice.
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id")
    private Sale sale;

    /**
     * The product associated with the invoice.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * The quantity of the product in the invoice.
     */
    private Integer quantity;

    /**
     * The subtotal amount of the invoice.
     */
    private Double subtotal;

    /**
     * The discount applied to the invoice.
     */
    private Integer discount;

    /**
     * The status of the invoice.
     */
    private Boolean status;

    /**
     * Constructs a new Invoice object.
     *
     * @param saleParam     the sale associated with the invoice
     * @param productParam  the product associated with the invoice
     * @param quantityParam the quantity of the product in the invoice
     * @param subtotalParam the subtotal amount of the invoice
     * @param discountParam the discount applied to the invoice
     * @param statusParam   the status of the invoice
     */
    public Invoice(final Sale saleParam, final Product productParam, final Integer quantityParam,
                   final Double subtotalParam, final Integer discountParam, final Boolean statusParam) {
        this.sale = saleParam;
        this.product = productParam;
        this.quantity = quantityParam;
        this.subtotal = subtotalParam;
        this.discount = discountParam;
        this.status = statusParam;
    }

    /**
     * Constructs a new Invoice object.
     */
    public Invoice() {
    }

}
