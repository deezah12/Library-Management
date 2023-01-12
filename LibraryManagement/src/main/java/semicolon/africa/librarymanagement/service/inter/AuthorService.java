package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.AuthorRequest;
import semicolon.africa.librarymanagement.models.Author;

import java.util.List;

public interface AuthorService {
    Author findAuthorById (String id);
    Author createAuthor (AuthorRequest authorRequest);
    Author updateAuthor (String id, AuthorRequest authorRequest);
    void deleteAuthor (String id);
    List<Author> findAllAuthor();

    Author findByAuthor(String name);
}
