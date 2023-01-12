package semicolon.africa.librarymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.librarymanagement.dto.request.AuthorRequest;
import semicolon.africa.librarymanagement.exceptions.EntityDoesNotExistException;
import semicolon.africa.librarymanagement.exceptions.UserNotFoundException;
import semicolon.africa.librarymanagement.models.Author;
import semicolon.africa.librarymanagement.repositories.AuthorJpa;
import semicolon.africa.librarymanagement.service.inter.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorJpa authorJpa;


    @Override
    public Author findAuthorById(String id) {
        return authorJpa.findById(id).orElseThrow(()-> new EntityDoesNotExistException(String.format("Author with %s id not found", id)));
    }

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setDescription(authorRequest.getDescription());
        authorJpa.save(author);
        return author;
    }

    @Override
    public Author updateAuthor(String id, AuthorRequest authorRequest) {
        var foundAuthor = authorJpa.findById(id).orElseThrow(()-> new EntityDoesNotExistException("this user does not exist"));
        foundAuthor.setName(authorRequest.getName());
        foundAuthor.setDescription(authorRequest.getDescription());
        authorJpa.save(foundAuthor);
        return foundAuthor;

    }

    @Override
    public void deleteAuthor(String id) {
        var foundId = authorJpa.findById(id).orElseThrow(()-> new UserNotFoundException("user does not exist"));
        authorJpa.deleteById(foundId.getId());
    }

    @Override
    public List<Author> findAllAuthor() {
        return authorJpa.findAll();
    }

    @Override
    public Author findByAuthor(String name) {
        return authorJpa.findByName(name);
    }
}
