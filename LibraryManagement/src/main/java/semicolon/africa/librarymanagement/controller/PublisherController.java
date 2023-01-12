package semicolon.africa.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.librarymanagement.dto.request.PublisherRequest;
import semicolon.africa.librarymanagement.dto.response.ApiResponse;
import semicolon.africa.librarymanagement.exceptions.EntityDoesNotExistException;
import semicolon.africa.librarymanagement.service.inter.PublisherService;
import java.util.List;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {
    @Autowired
    PublisherService publisherService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody  PublisherRequest publisherRequest){
        var buildPublisher = publisherService.createPublisher(publisherRequest);
        return  new ResponseEntity<>(new ApiResponse(true, buildPublisher), HttpStatus.CREATED);
    }

    @PutMapping("/{publisherId}")
    public ResponseEntity<?> update(@RequestBody PublisherRequest publisherRequest, @PathVariable String publisherId){
        var rebuildPublisher = publisherService.updatePublisher(publisherId, publisherRequest);
        return  new ResponseEntity<>(new ApiResponse(true, rebuildPublisher), HttpStatus.ACCEPTED);
    }

    @GetMapping("/allPublisher")
    public List<?> getPublishers(){
        return publisherService.findAllPublisher();
    }

    @GetMapping("/{publisherId}")
    public ResponseEntity<?> getPublisherById(@PathVariable String publisherId)throws EntityDoesNotExistException {
        var foundPublisherId = publisherService.findPublisherById(publisherId);
        return  new ResponseEntity<>(new ApiResponse(true, foundPublisherId), HttpStatus.FOUND);
    }
    @DeleteMapping("/{publisherId}")
    public ResponseEntity<?> delete(@PathVariable String publisherId){
        publisherService.deletePublisher(publisherId);
        return new ResponseEntity<>(new ApiResponse(true), HttpStatus.OK);
    }
}
