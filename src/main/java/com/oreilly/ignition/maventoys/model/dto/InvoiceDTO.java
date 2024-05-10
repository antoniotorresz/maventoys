package com.oreilly.ignition.maventoys.model.dto;

public class InvoiceDTO {
    /**
     * The ID of the product.
     */
    private Long productId;

    /**
     * The quantity of the product.
     */
    private int quantity;

    /**
     * The subtotal of the invoice.
     */
    private Double subtotal;

    /**
     * The discount applied to the invoice.
     */
    private Float discount;

    /**
     * The status of the invoice.
     */
    private String status;
}
