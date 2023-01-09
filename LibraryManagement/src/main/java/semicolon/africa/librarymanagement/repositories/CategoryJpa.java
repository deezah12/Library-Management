package semicolon.africa.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.librarymanagement.models.Category;
@Repository
public interface CategoryJpa extends MongoRepository<Category, String> {

}
