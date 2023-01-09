package semicolon.africa.librarymanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
public class Book {
    @Id private String id;
    private String isbn;
    private String name;
    private String description;
    @DBRef private Set<Publisher>  publishers;
    @DBRef private Set<Author> authors;
    @DBRef private Set<Category> categories;
}
