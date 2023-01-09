package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.AuthorRequest;
import semicolon.africa.librarymanagement.dto.response.AuthorResponse;
import semicolon.africa.librarymanagement.models.Author;

import java.util.List;

public interface AuthorService {
    Author findById (String id);
    AuthorResponse createAuthor (AuthorRequest authorRequest);
    AuthorResponse updateAuthor (String id, AuthorRequest authorRequest);
    void deleteAuthor (AuthorRequest authorRequest);
    List<Author> findAllAuthor();
}
