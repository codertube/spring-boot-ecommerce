package com.backend.ecommerce.entity;

import com.backend.ecommerce.dto.OrderProductDto;

import java.util.List;

public class OrderForm {

    private List<OrderProductDto> productOrders;

    public List<OrderProductDto> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<OrderProductDto> productOrders) {
        this.productOrders = productOrders;
    }
}
