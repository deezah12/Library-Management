package semicolon.africa.librarymanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "categories")
@Data
public class Category {

    @JsonIgnore
    @Id private String id;
    private String name;
    @DBRef private Book books;
}
