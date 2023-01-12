package semicolon.africa.librarymanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
public class User {
    @JsonIgnore
    @Id private String userId;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
}
