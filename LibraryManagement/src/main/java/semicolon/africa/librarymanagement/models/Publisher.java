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
public class Publisher {
    @Id
    private String id;
    private String name;
    @DBRef
    private Set<Book> books;
}
