package com.oreilly.ignition.maventoys.model.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = "invoices")
@Data
@Entity
@Table(name = "products")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product {
    /**
     * The unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * The name of the product.
     */
    private String name;
    /**
     * The cost of the product.
     */
    private Double cost;
    /**
     * The price of the product.
     */
    private Double price;
    /**
     * The creation date of the product.
     */
    private Date creationDate;
    /**
     * The status of the product (active or inactive).
     */
    private Boolean active;
    /**
     * The category of the product.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * The invoices associated with the product.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Invoice> invoices;

    /**
     * Default constructor for the Product class.
     */
    public Product() {
    }

    /**
     * Constructor that initializes the ID, name, cost, price, creation date, and
     * category.
     *
     * @param idParam           The ID of the product.
     * @param nameParam         The name of the product.
     * @param costParam         The cost of the product.
     * @param priceParam        The price of the product.
     * @param creationDateParam The creation date of the product.
     * @param categoryParam     The category of the product.
     */
    public Product(final Integer idParam, final String nameParam, final Double costParam, final Double priceParam,
            final Date creationDateParam, final Category categoryParam) {
        this.id = idParam;
        this.name = nameParam;
        this.cost = costParam;
        this.price = priceParam;
        this.creationDate = new Date();
        this.active = true;
        this.category = categoryParam;
    }

    /**
     * Constructor that initializes the ID.
     *
     * @param idParam The ID of the product.
     */
    public Product(final int idParam) {
        this.id = idParam;
    }

}
