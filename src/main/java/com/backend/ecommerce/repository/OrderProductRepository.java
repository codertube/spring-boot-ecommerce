package com.backend.ecommerce.repository;

import com.backend.ecommerce.entity.OrderProduct;
import com.backend.ecommerce.entity.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}
