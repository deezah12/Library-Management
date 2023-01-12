package semicolon.africa.librarymanagement.dto.request;


import lombok.Data;
import semicolon.africa.librarymanagement.models.Author;
import semicolon.africa.librarymanagement.models.Category;
import semicolon.africa.librarymanagement.models.Publisher;

@Data
public class BookRequest{
    private String isbn;
    private String name;
    private String description;
    private Category category;
    private Publisher publisher;
    private Author author;

}
