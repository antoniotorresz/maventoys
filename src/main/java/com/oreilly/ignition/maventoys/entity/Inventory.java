package com.oreilly.ignition.maventoys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonProperty(access = JsonProperty.Access.AUTO)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private Integer stockOnHand;

    public Inventory() {
    }

    public Inventory(Integer id, Product product, Integer stockOnHand) {
        this.id = id;
        this.product = product;
        this.stockOnHand = stockOnHand;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getStockOnHand() {
        return this.stockOnHand;
    }

    public void setStockOnHand(Integer stockOnHand) {
        this.stockOnHand = stockOnHand;
    }

}
