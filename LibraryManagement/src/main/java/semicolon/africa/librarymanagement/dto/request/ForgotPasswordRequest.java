package semicolon.africa.librarymanagement.dto.request;

import lombok.Data;
import semicolon.africa.librarymanagement.models.User;

@Data
public class ForgotPasswordRequest {
    private User user;
    private String path;
    private String token;
}
