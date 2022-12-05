package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.OrderProduct;
import com.backend.ecommerce.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
