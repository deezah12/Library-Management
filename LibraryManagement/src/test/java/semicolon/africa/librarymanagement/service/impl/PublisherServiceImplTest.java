package semicolon.africa.librarymanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.librarymanagement.dto.request.PublisherRequest;
import semicolon.africa.librarymanagement.service.inter.PublisherService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublisherServiceImplTest {
    @Autowired
    PublisherService publisherService;

    @Test
    void createPublisher() {
        PublisherRequest publisherRequest = new PublisherRequest();
        publisherRequest.setName("semicolon");
        publisherService.createPublisher(publisherRequest);

        var publisherResponse =  publisherService.createPublisher(publisherRequest);
        assertEquals("successful", publisherResponse.getMessage());
    }

    @Test
    void updatePublisher() {
    }
}