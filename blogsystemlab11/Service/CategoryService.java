package com.example.blogsystemlab11.Service;

import com.example.blogsystemlab11.ApiResponse.ApiException;
import com.example.blogsystemlab11.Model.Category;
import com.example.blogsystemlab11.Model.User;
import com.example.blogsystemlab11.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category category) {
        Category check = categoryRepository.findCategoryById(id);
        if (check != null) {
            check.setName(category.getName());
            categoryRepository.save(check);
        }
        throw new ApiException("category not found");
    }

    public void deleteCategory(Integer id) {
        if (categoryRepository.findCategoryById(id) != null) {
            categoryRepository.delete(categoryRepository.findCategoryById(id));
        }
        throw new ApiException("category not found");
    }


}
