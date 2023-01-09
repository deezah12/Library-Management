package semicolon.africa.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.librarymanagement.models.Book;
@Repository
public interface BookJpa extends MongoRepository<Book, String> {
}
