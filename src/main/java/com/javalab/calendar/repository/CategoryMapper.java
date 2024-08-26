package com.javalab.calendar.repository;

import com.javalab.calendar.vo.CategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryVo> findAllCategories();

    CategoryVo findCategoryById(@Param("categoryId") int categoryId);

    void insertCategory(CategoryVo category);

    void updateCategory(CategoryVo category);

    void deleteCategory(@Param("categoryId") int categoryId);
}
