package com.ecommerce.sbEcommerce.service;

import com.ecommerce.sbEcommerce.Exceptions.APIException;
import com.ecommerce.sbEcommerce.Exceptions.ResourseNotFoundException;
import com.ecommerce.sbEcommerce.Repository.CategoryRepository;
import com.ecommerce.sbEcommerce.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new APIException("No Category created till now");
        }
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!!");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourseNotFoundException("Category" , "categoryId" , categoryId));
        categoryRepository.delete(category);
        return "Category with categoryId : " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourseNotFoundException("Category" , "categoryId" , categoryId));
        category.setCategoryId(categoryId);
        Category updatedCategory = categoryRepository.save(category);
        return updatedCategory;
    }
}
