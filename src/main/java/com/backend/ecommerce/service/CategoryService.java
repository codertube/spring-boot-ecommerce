package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Category;
import com.backend.ecommerce.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    public void removeCategory(Category category) {
        categoryRepository.delete(category);
    }
}
