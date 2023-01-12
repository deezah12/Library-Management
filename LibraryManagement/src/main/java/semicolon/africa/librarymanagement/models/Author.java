package semicolon.africa.librarymanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document(collection = "authors")
@Data
public class Author {
    @JsonIgnore
    @Id private String id;
    private String name;
    private String description;
    @DBRef
    private Book books;
}
