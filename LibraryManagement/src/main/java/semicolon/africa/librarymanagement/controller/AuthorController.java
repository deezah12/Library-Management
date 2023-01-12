package semicolon.africa.librarymanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.librarymanagement.dto.request.AuthorRequest;
import semicolon.africa.librarymanagement.dto.response.ApiResponse;
import semicolon.africa.librarymanagement.exceptions.EntityDoesNotExistException;
import semicolon.africa.librarymanagement.service.inter.AuthorService;
import java.util.List;


@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("")
    public ResponseEntity<?> create (@RequestBody AuthorRequest authorRequest){
       var build = authorService.createAuthor(authorRequest);
        return new ResponseEntity<>(new ApiResponse(true, build), HttpStatus.CREATED);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<?> update(@RequestBody AuthorRequest authorRequest, @PathVariable String authorId){
        var rebuild = authorService.updateAuthor(authorId, authorRequest);
        return new ResponseEntity<>(new ApiResponse(true, rebuild), HttpStatus.OK);
    }

    @GetMapping("/allAuthor")
    public List<?> getAuthors(){
        return authorService.findAllAuthor();
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<?> getAuthorById(@PathVariable String authorId)throws EntityDoesNotExistException {
       var foundAuthor = authorService.findAuthorById(authorId);
       return new  ResponseEntity<>(new ApiResponse(true, foundAuthor), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete{authorId}")
    public ResponseEntity<?> deleteAuthor(@PathVariable String authorId){
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(new ApiResponse(true, authorId), HttpStatus.OK);
    }

}
