package semicolon.africa.librarymanagement.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ResetPasswordRequest {
    String id;
    @Pattern(regexp = "^(?=.*\\d)+(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])+.{8,16}$")
    String password;
}
