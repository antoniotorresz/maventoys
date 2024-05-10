package com.oreilly.ignition.maventoys.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SaleDto {
    /**
     * The employee ID.
     */
    private Integer employeeId;

    /**
     * The store ID.
     */
    private Integer storeId;

    /**
     * The list of product quantities.
     */
    private List<ProductQuantity> productQuantity = new ArrayList<>();

    /**
     * @return the employeeId
     */
    public Integer getEmployeeId() {
        return this.employeeId;
    }

    /**
     * @param employeeIdParam the employeeId to set
     */
    public void setEmployeeId(final Integer employeeIdParam) {
        this.employeeId = employeeIdParam;
    }

    /**
     * @return the storeId
     */
    public Integer getStoreId() {
        return this.storeId;
    }

    /**
     * @param storeIdParam the storeId to set
     */
    public void setStoreId(final Integer storeIdParam) {
        this.storeId = storeIdParam;
    }

    /**
     * @return the productQuantity
     */
    public List<ProductQuantity> getProductQuantity() {
        return productQuantity;
    }

    /**
     * @param productQuantityParam the productQuantity to set
     */
    public void setProductQuantity(final List<ProductQuantity> productQuantityParam) {
        this.productQuantity = productQuantityParam;
    }
}
