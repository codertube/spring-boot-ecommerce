package com.backend.ecommerce.controller;

import com.backend.ecommerce.dto.OrderProductDto;
import com.backend.ecommerce.entity.Order;
import com.backend.ecommerce.entity.OrderForm;
import com.backend.ecommerce.entity.OrderProduct;
import com.backend.ecommerce.entity.OrderStatus;
import com.backend.ecommerce.exception.ResourceNotFoundException;
import com.backend.ecommerce.service.OrderProductService;
import com.backend.ecommerce.service.OrderService;
import com.backend.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderProductService orderProductService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = this.orderService.getAllOrders();
        if (!orders.isEmpty()) {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        return null;
    }

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order,
                    productService.getProductById(dto.getProduct().getId()), dto.getQuantity(),
                    dto.getProduct().getPrice())));
        }
        order.getTotalOrderPrice();
        order.setOrderProducts(orderProducts);
        this.orderService.update(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts.stream()
                .filter(op -> Objects.isNull(productService.getProductById(op.getProduct().getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }
}
