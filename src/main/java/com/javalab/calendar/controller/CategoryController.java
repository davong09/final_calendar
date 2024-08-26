package com.javalab.calendar.controller;

import com.javalab.calendar.dto.CategoryFormDto;
import com.javalab.calendar.service.CategoryService;
import com.javalab.calendar.vo.CategoryVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    // 카테고리 목록 조회
    @GetMapping("/list")
    public String listCategories(Model model) {
        List<CategoryVo> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "admin/categoryList"; // 카테고리 목록을 보여주는 뷰
    }

    // 카테고리 생성 폼
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("categoryFormDto", new CategoryFormDto());
        return "admin/categoryCreate"; // 카테고리 생성 폼을 보여주는 뷰
    }

    // 카테고리 생성 처리
    @PostMapping("/create")
    public String createCategory(@Valid @ModelAttribute("categoryFormDto") CategoryFormDto categoryFormDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/categoryCreate"; // 폼 입력 오류 시 다시 폼 페이지로 이동
        }

        CategoryVo category = CategoryVo.builder()
                .categoryId(categoryFormDto.getCategoryId())
                .categoryName(categoryFormDto.getCategoryName())
                .build();

        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message", "카테고리가 성공적으로 생성되었습니다.");
        return "redirect:/category/list"; // 생성 후 목록 페이지로 리다이렉트
    }

    // 카테고리 수정 폼
    @GetMapping("/update/{categoryId}")
    public String showUpdateForm(@PathVariable("categoryId") int categoryId, Model model) {
        CategoryVo category = categoryService.findCategoryById(categoryId);
        if (category == null) {
            return "redirect:/category/list"; // 카테고리가 존재하지 않을 경우 목록 페이지로 리다이렉트
        }

        CategoryFormDto categoryFormDto = CategoryFormDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();

        model.addAttribute("categoryFormDto", categoryFormDto);
        return "admin/categoryUpdate"; // 카테고리 수정 폼을 보여주는 뷰
    }

    // 카테고리 수정 처리
    @PostMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") int categoryId,
                                 @Valid @ModelAttribute("categoryFormDto") CategoryFormDto categoryFormDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "admin/categoryUpdate"; // 폼 입력 오류 시 수정 폼 페이지로 이동
        }

        CategoryVo category = CategoryVo.builder()
                .categoryId(categoryId)
                .categoryName(categoryFormDto.getCategoryName())
                .build();

        categoryService.updateCategory(category);
        redirectAttributes.addFlashAttribute("message", "카테고리가 성공적으로 수정되었습니다.");
        return "redirect:/category/list"; // 수정 후 목록 페이지로 리다이렉트
    }

    // 카테고리 삭제 처리
    @PostMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") int categoryId,
                                 RedirectAttributes redirectAttributes) {
        categoryService.deleteCategory(categoryId);
        redirectAttributes.addFlashAttribute("message", "카테고리가 성공적으로 삭제되었습니다.");
        return "redirect:/category/list"; // 삭제 후 목록 페이지로 리다이렉트
    }
}
