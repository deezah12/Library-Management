package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.PublisherRequest;
import semicolon.africa.librarymanagement.models.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher createPublisher (PublisherRequest publisherRequest);
    Publisher updatePublisher (String id, PublisherRequest publisherRequest);
    void deletePublisher (String id);
    Publisher findPublisherById(String id);
    List<Publisher> findAllPublisher();
    Publisher findByPublisher(String name);
}
