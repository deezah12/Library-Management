package semicolon.africa.librarymanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.librarymanagement.dto.request.BookRequest;
import semicolon.africa.librarymanagement.models.Category;
import semicolon.africa.librarymanagement.repositories.AuthorJpa;
import semicolon.africa.librarymanagement.repositories.BookJpa;
import semicolon.africa.librarymanagement.repositories.CategoryJpa;
import semicolon.africa.librarymanagement.repositories.PublisherJpa;
import semicolon.africa.librarymanagement.service.inter.AuthorService;
import semicolon.africa.librarymanagement.service.inter.BookService;
import semicolon.africa.librarymanagement.service.inter.CategoryService;
import semicolon.africa.librarymanagement.service.inter.PublisherService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceImplTest {

    @Autowired
    CategoryService categoryService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @Test
    void addBook() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setName("bible");
        bookRequest.setDescription("my life here on earth");
        bookRequest.setIsbn("23678A");


        var categoryName = categoryService.findByCategory("comedy");
        bookRequest.setCategory(categoryName);

        var publisherName = publisherService.findByPublisher("semicolon");
        bookRequest.setPublisher(publisherName);

        var authorName = authorService.findByAuthor("chibuzor");
        bookRequest.setAuthor(authorName);
        //bookRequest.setDescription("java engineer");
        bookService.addBook(bookRequest, categoryName, publisherName, authorName);

        var bookResponse = bookService.addBook(bookRequest, categoryName, publisherName, authorName);
        assertEquals("successful", bookResponse.getMessage());
    }
}