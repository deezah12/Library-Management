package semicolon.africa.librarymanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.librarymanagement.dto.request.AuthorRequest;
import semicolon.africa.librarymanagement.repositories.AuthorJpa;
import semicolon.africa.librarymanagement.service.inter.AuthorService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorServiceImplTest {

    @Autowired
    AuthorService authorService;

    @Test
    void createAuthor() {
        AuthorRequest authorRequest = new AuthorRequest();
        authorRequest.setName("chibuzor");
        authorRequest.setDescription("java engineer");
        authorService.createAuthor(authorRequest);

        var authorResponse = authorService.createAuthor(authorRequest);
        assertEquals("successful", authorResponse.getMessage());
    }

    @Test
    void updateAuthor() {
    }
}