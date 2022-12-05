package com.backend.ecommerce.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.backend.ecommerce.entity.Product;
import com.backend.ecommerce.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void whenGetProducts_thenReturnJsonArray() throws Exception {
        Product product = new Product(1L,"Muffin",1.50,"'assets/images/Muffin.jpg'");
        Product product2 = new Product(2L,"Brownie",2.00,"'assets/images/Brownie.jpg'");

        List<Product> allProducts = Arrays.asList(product, product2);

        given(service.getProducts()).willReturn(allProducts);

        mvc.perform(get("/api/products").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].name", is(product2.getName())));
        verify(service, VerificationModeFactory.times(1)).getProducts();
        reset(service);
    }
}
