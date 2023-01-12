package semicolon.africa.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.librarymanagement.dto.request.CategoryRequest;
import semicolon.africa.librarymanagement.dto.response.ApiResponse;
import semicolon.africa.librarymanagement.exceptions.EntityDoesNotExistException;
import semicolon.africa.librarymanagement.models.Category;
import semicolon.africa.librarymanagement.service.inter.CategoryService;
import java.util.List;


@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<?> create (@RequestBody CategoryRequest categoryRequest){
        var buildUser = categoryService.createCategory(categoryRequest);
        return  new ResponseEntity<>(new ApiResponse(true, buildUser), HttpStatus.CREATED);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<?> update(@RequestBody CategoryRequest categoryRequest, @PathVariable String categoryId){
        var rebuildUser = categoryService.updateCategory(categoryId, categoryRequest);
        return  new ResponseEntity<>(new ApiResponse(true, rebuildUser), HttpStatus.OK);
    }

    @GetMapping("/allCategory")
    public List<?> getCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getPublisherById(@PathVariable String categoryId)throws EntityDoesNotExistException {
        var foundCategory = categoryService.findCategoryById(categoryId);
        return  new ResponseEntity<>(new ApiResponse(true, foundCategory), HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> delete(@PathVariable String categoryId) throws EntityDoesNotExistException{
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse(true), HttpStatus.OK);
    }
}
