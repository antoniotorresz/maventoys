package com.oreilly.ignition.maventoys.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {
    
    @EmbeddedId
    private InvoiceId id;

    private Integer quantity;
    private Double subtotal;
    private Float discount;
    private Byte status;
    private Integer products;
    public Invoice() {
    }

    

    public Invoice(InvoiceId id, Integer quantity, Double subtotal, Float discount, Byte status) {
        this.id = id;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.discount = discount;
        this.status = status;
        this.products = 0;
    }



    public Invoice(Integer quantity, Double subtotal, Float discount) {
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.discount = discount;
        this.status = 1;
    }

    public InvoiceId getId() {
        return id;
    }

    public void setId(InvoiceId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }


    public Integer getProducts() {
        return products;
    }


    public void setProducts(Integer products) {
        this.products = products;
    }

    
    
}
