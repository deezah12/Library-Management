package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.CategoryRequest;
import semicolon.africa.librarymanagement.models.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory (CategoryRequest categoryRequest);
    Category updateCategory (String id, CategoryRequest categoryRequest);
    void deleteCategory (String id);
    List<Category> findAllCategories();
    Category findCategoryById(String id);
    Category findByCategory(String name);
}
