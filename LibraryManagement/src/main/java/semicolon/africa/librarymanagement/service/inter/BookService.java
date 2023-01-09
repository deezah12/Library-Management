package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.BookRequest;
import semicolon.africa.librarymanagement.dto.response.BookResponse;
import semicolon.africa.librarymanagement.models.Book;

import java.util.List;

public interface BookService {
    BookResponse createBook (BookRequest bookRequest);
    BookResponse updateBook (String id, BookRequest bookRequest);
    void deleteBook (String id);
    List<Book> findAllBooks();
}
