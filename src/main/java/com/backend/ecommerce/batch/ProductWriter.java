/*
package com.backend.ecommerce.batch;

import java.util.List;

import com.backend.ecommerce.entity.Product;
import com.backend.ecommerce.repository.ProductRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductWriter implements ItemWriter<Product> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void write(List<? extends Product> productList) throws Exception {
        for (Product data : productList) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getId() + " : " + data.getName());
            productRepository.save(data);
        }
    }
}
*/
