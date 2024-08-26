package com.javalab.calendar.service;

import com.javalab.calendar.vo.CategoryVo;

import java.util.List;

public interface CategoryService {

    List<CategoryVo> findAllCategories();

    CategoryVo findCategoryById(int categoryId);

    void saveCategory(CategoryVo category);

    void updateCategory(CategoryVo category);

    void deleteCategory(int categoryId);
}
