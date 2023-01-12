package semicolon.africa.librarymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.librarymanagement.dto.request.BookRequest;
import semicolon.africa.librarymanagement.dto.request.BorrowRequest;
import semicolon.africa.librarymanagement.exceptions.UserNotFoundException;
import semicolon.africa.librarymanagement.models.Author;
import semicolon.africa.librarymanagement.models.Book;
import semicolon.africa.librarymanagement.models.Category;
import semicolon.africa.librarymanagement.models.Publisher;
import semicolon.africa.librarymanagement.repositories.BookJpa;
import semicolon.africa.librarymanagement.service.inter.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookJpa bookJpa;



    @Override
    public Book addBook(BookRequest bookRequest, Category category, Publisher publisher, Author author) {
        Book book = new Book();
        book.setTitle(bookRequest.getName());
        book.setIsbn(bookRequest.getIsbn());
        book.setDescription(bookRequest.getDescription());
        book.setAuthor(author);
        book.setCategory(category);
        book.setPublisher(publisher);
        bookJpa.save(book);

        return book;
    }

    @Override
    public Book updateBook(String id, BookRequest bookRequest) {
        var foundBook = bookJpa.findById(id).orElseThrow(()-> new UserNotFoundException("Book not found"));
        foundBook.setTitle(bookRequest.getName());
        foundBook.setIsbn(bookRequest.getIsbn());
        foundBook.setDescription(bookRequest.getDescription());
        foundBook.setAuthor(bookRequest.getAuthor());
        foundBook.setPublisher(bookRequest.getPublisher());
        foundBook.setCategory(bookRequest.getCategory());
        bookJpa.save(foundBook);
        return foundBook;
    }

    @Override
    public void deleteBook(String id) {
        var foundId = bookJpa.findById(id).orElseThrow(()-> new UserNotFoundException("book does not exist"));
        bookJpa.deleteById(foundId.getId());
    }

    @Override
    public List<Book> findAllBooks() {
        return bookJpa.findAll();
    }

    @Override
    public Book borrow(BorrowRequest borrowRequest) {
        var foundBook = bookJpa.findByTitle(borrowRequest.getTitle());
        var isAvailable = foundBook.getAvailable();
        if (isAvailable){
            int i = foundBook.getQuantity() - 1;
        }

        return null;
    }


}
