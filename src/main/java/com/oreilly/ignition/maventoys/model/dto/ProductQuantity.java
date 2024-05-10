package com.oreilly.ignition.maventoys.model.dto;

public class ProductQuantity {
    /**
     * The ID of the product.
     */
    private Integer productId;

    /**
     * The quantity of the product.
     */
    private Integer quantity;

    /**
     * The discount applied to the product.
     */
    private Integer discount;

    /**
     * Constructs a new ProductQuantity instance.
     */
    public ProductQuantity() {
    }

    /**
     * Get the ID of the product.
     * @return The product ID.
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Set the ID of the product.
     * @param productIdParam The product ID to set.
     */
    public void setProductId(final Integer productIdParam) {
        this.productId = productIdParam;
    }

    /**
     * Get the quantity of the product.
     * @return The product quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product.
     * @param quantityParam The product quantity to set.
     */
    public void setQuantity(final Integer quantityParam) {
        this.quantity = quantityParam;
    }

    /**
     * Get the discount applied to the product.
     * @return The product discount.
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * Set the discount applied to the product.
     * @param discountParam The product discount to set.
     */
    public void setDiscount(final Integer discountParam) {
        this.discount = discountParam;
    }
}
