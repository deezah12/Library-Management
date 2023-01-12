package semicolon.africa.librarymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.librarymanagement.dto.request.PublisherRequest;
import semicolon.africa.librarymanagement.exceptions.EntityDoesNotExistException;
import semicolon.africa.librarymanagement.exceptions.UserNotFoundException;
import semicolon.africa.librarymanagement.models.Publisher;
import semicolon.africa.librarymanagement.repositories.PublisherJpa;
import semicolon.africa.librarymanagement.service.inter.PublisherService;
import java.util.List;


@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherJpa publisherJpa;


    @Override
    public Publisher createPublisher(PublisherRequest publisherRequest) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherRequest.getName());
        publisherJpa.save(publisher);
        return publisher;
    }

    @Override
    public Publisher updatePublisher(String id, PublisherRequest publisherRequest) {
        var foundPublisher = publisherJpa.findById(id).orElseThrow(()-> new EntityDoesNotExistException("publisher not found"));
        foundPublisher.setName(publisherRequest.getName());
        publisherJpa.save(foundPublisher);
        return foundPublisher;
    }

    @Override
    public void deletePublisher(String id) {
        var foundId = publisherJpa.findById(id).orElseThrow(()-> new UserNotFoundException("publisher does not exist"));
        publisherJpa.delete(foundId);
    }

    @Override
    public Publisher findPublisherById(String id) {
        return publisherJpa.findById(id).orElseThrow(()-> new EntityDoesNotExistException(String.format("Publisher with %s id does not exist", id)));
    }
    @Override
    public List<Publisher> findAllPublisher() {
        return publisherJpa.findAll();
    }

    @Override
    public Publisher findByPublisher(String name) {
        return publisherJpa.findByName(name);
    }
}
