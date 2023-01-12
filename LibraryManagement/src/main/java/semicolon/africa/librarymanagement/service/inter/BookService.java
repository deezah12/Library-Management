package semicolon.africa.librarymanagement.service.inter;
import semicolon.africa.librarymanagement.dto.request.BookRequest;
import semicolon.africa.librarymanagement.dto.request.BorrowRequest;
import semicolon.africa.librarymanagement.models.Author;
import semicolon.africa.librarymanagement.models.Book;
import semicolon.africa.librarymanagement.models.Category;
import semicolon.africa.librarymanagement.models.Publisher;

import java.util.List;

public interface BookService {
    Book addBook (BookRequest bookRequest, Category category, Publisher publisher, Author author);
    Book updateBook (String id, BookRequest bookRequest);
    void deleteBook (String id);
    List<Book> findAllBooks();

    Book borrow(BorrowRequest borrowRequest);


}
