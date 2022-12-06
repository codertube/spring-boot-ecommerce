package com.backend.ecommerce.batch;

import com.backend.ecommerce.entity.Category;
import com.backend.ecommerce.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.util.Arrays;
import java.util.List;

public class ProductItemProcessor implements ItemProcessor<Product, Product> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductItemProcessor.class);

    @Override
    public Product process(final Product product) throws Exception {
        List<String> bakesList = Arrays.asList("Brownie", "Muffin", "Cake Pop", "Apple tart", "Water");
        if (bakesList.contains(product.getName())) {
            product.setCategory(new Category(1L, "Bakes"));
        } else {
            product.setCategory(new Category(2L, "Used-Items"));
        }
        return product;
    }

}
