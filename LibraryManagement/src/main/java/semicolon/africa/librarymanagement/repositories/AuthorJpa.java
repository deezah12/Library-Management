package semicolon.africa.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.librarymanagement.models.Author;
@Repository
public interface AuthorJpa extends MongoRepository<Author, String> {


}
