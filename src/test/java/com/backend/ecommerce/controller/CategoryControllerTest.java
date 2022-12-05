package com.backend.ecommerce.controller;

import com.backend.ecommerce.entity.Category;
import com.backend.ecommerce.entity.Product;
import com.backend.ecommerce.service.CategoryService;
import com.backend.ecommerce.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CategoryController.class)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService service;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void whenGetProducts_thenReturnJsonArray() throws Exception {
        Category category = new Category(1L,"Bakes");
        Category category2 = new Category(2L,"Used-Items");

        List<Category> allCategories = Arrays.asList(category, category2);

        given(service.getCategories()).willReturn(allCategories);

        mvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].type", is(category2.getType())));
        verify(service, VerificationModeFactory.times(1)).getCategories();
        reset(service);
    }
}
