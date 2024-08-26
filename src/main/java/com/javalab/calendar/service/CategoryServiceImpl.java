package com.javalab.calendar.service;

import com.javalab.calendar.repository.CategoryMapper;
import com.javalab.calendar.vo.CategoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryVo> findAllCategories() {
        return categoryMapper.findAllCategories();
    }

    @Override
    public CategoryVo findCategoryById(int categoryId) {
        return categoryMapper.findCategoryById(categoryId);
    }

    @Override
    public void saveCategory(CategoryVo category) {
        categoryMapper.insertCategory(category);
    }

    @Override
    public void updateCategory(CategoryVo category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryMapper.deleteCategory(categoryId);
    }
}
