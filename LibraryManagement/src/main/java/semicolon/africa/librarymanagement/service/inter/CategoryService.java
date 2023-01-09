package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.BookRequest;
import semicolon.africa.librarymanagement.dto.request.CategoryRequest;
import semicolon.africa.librarymanagement.dto.response.CategoryResponse;
import semicolon.africa.librarymanagement.models.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory (CategoryRequest categoryRequest);
    CategoryResponse updateCategory (String id, CategoryRequest categoryRequest);
    void deleteCategory (String id);
    List<Category> findAllCategories();
    Category findById(String id);
}
