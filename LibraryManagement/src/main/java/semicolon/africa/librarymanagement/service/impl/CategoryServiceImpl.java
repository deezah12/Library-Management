package semicolon.africa.librarymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.librarymanagement.dto.request.CategoryRequest;
import semicolon.africa.librarymanagement.exceptions.EntityDoesNotExistException;
import semicolon.africa.librarymanagement.models.Category;
import semicolon.africa.librarymanagement.repositories.CategoryJpa;
import semicolon.africa.librarymanagement.service.inter.CategoryService;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryJpa categoryJpa;

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryJpa.save(category);

//        CategoryResponse categoryResponse = new CategoryResponse();
//        categoryResponse.setMessage("successful");
        return category;
    }

    @Override
    public Category updateCategory(String id, CategoryRequest categoryRequest) {
        var foundCategory = categoryJpa.findById(id).orElseThrow(()-> new EntityDoesNotExistException("Category not found"));
        foundCategory.setName(categoryRequest.getName());
        categoryJpa.save(foundCategory);

       return foundCategory;
    }

    @Override
    public void deleteCategory(String id) {
        var foundId = categoryJpa.findById(id).orElseThrow(()-> new EntityDoesNotExistException("category does not exist"));
        categoryJpa.deleteById(foundId.getId());
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryJpa.findAll();
    }

    @Override
    public Category findCategoryById(String id) {
        return categoryJpa.findById(id).orElseThrow(()-> new EntityDoesNotExistException(String.format("category with %s does not exist", id)));
    }
    @Override
    public Category findByCategory(String name) {
        return categoryJpa.findByName(name);
    }
}
