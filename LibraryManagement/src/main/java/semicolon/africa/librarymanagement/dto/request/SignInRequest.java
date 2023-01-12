package semicolon.africa.librarymanagement.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Data
public class SignInRequest {
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^(?=.*\\d)+(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])+.{8,16}$")
    private String password;

    @Email
    @Indexed(unique = true)
    private  String email;
    private LocalDateTime createdTime = LocalDateTime.now();
}
