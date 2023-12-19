package com.oreilly.ignition.maventoys.dto;

public class ProductSales {
    private Integer productId;
    private Integer totalSold;

    public ProductSales() {
    }

    public ProductSales(Integer productId, Integer totalSold) {
        this.productId = productId;
        this.totalSold = totalSold;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTotalSold() {
        return this.totalSold;
    }

    public void setTotalSold(Integer totalSold) {
        this.totalSold = totalSold;
    }

}
