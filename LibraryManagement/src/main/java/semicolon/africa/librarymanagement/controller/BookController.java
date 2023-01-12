package semicolon.africa.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.librarymanagement.dto.request.BookRequest;
import semicolon.africa.librarymanagement.dto.response.ApiResponse;
import semicolon.africa.librarymanagement.models.Author;
import semicolon.africa.librarymanagement.models.Category;
import semicolon.africa.librarymanagement.models.Publisher;
import semicolon.africa.librarymanagement.service.inter.BookService;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<?> addBook (@RequestParam BookRequest bookRequest, Category category, Publisher publisher, Author author){
        bookService.addBook(bookRequest, category, publisher, author);
        return  new ResponseEntity<>(new ApiResponse(true, bookRequest), HttpStatus.CREATED);
    }

}
