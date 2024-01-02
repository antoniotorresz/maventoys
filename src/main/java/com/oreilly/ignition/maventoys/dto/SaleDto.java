package com.oreilly.ignition.maventoys.dto;

import java.util.ArrayList;
import java.util.List;

public class SaleDTO {
    private Integer employeeId;
    private Integer storeId;
    private List<ProductQuantity> productQuantity = new ArrayList<>();

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getStoreId() {
        return this.storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<ProductQuantity> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(List<ProductQuantity> productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "SaleDTO [employeeId=" + employeeId + ", storeId=" + storeId + ", productQuantity=" + productQuantity.toString()
                + "]";
    }

    
}
