package semicolon.africa.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.librarymanagement.models.Publisher;

@Repository
public interface PublisherJpa extends MongoRepository<Publisher, String> {
    Publisher findByName(String name);
}
