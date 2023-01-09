package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.PublisherRequest;
import semicolon.africa.librarymanagement.dto.response.PublisherResponse;
import semicolon.africa.librarymanagement.models.Publisher;

import java.util.List;

public interface PublisherService {
    PublisherResponse createPublisher (PublisherRequest publisherRequest);
    PublisherResponse updatePublisher (String id, PublisherRequest publisherRequest);
    void deletePublisher (String id);
    Publisher findById(String id);
    List<Publisher> findAllPublisher();
}
