package semicolon.africa.librarymanagement.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SigInRequest {
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime createdTime = LocalDateTime.now();
}
