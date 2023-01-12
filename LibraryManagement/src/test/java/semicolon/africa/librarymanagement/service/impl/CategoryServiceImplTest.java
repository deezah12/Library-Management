package semicolon.africa.librarymanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.librarymanagement.dto.request.CategoryRequest;
import semicolon.africa.librarymanagement.service.inter.CategoryService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;
    @Test
    void createCategory() {
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setName("comedy");
        categoryService.createCategory(categoryRequest);

        var categoryResponse = categoryService.createCategory(categoryRequest);
        assertEquals("successful", categoryResponse.getMessage());
    }

    @Test
    void updateCategory() {

    }
}