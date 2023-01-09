package semicolon.africa.librarymanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequest{
    private String isbn;
    private String name;
    private String description;

}
