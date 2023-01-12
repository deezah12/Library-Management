package semicolon.africa.librarymanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.librarymanagement.models.User;

@Repository
public interface UserJpa extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByUserId(String id);

}
