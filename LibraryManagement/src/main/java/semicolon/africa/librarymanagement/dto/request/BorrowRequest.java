package semicolon.africa.librarymanagement.dto.request;

import lombok.Data;
import semicolon.africa.librarymanagement.models.Book;

@Data
public class BorrowRequest {
    private String title;

}
