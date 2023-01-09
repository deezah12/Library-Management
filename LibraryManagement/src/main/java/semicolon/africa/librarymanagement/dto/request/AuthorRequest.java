package semicolon.africa.librarymanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorRequest {
    private String name;
    private String description;
}
