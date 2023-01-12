package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.LoginRequest;
import semicolon.africa.librarymanagement.dto.request.ResetPasswordRequest;
import semicolon.africa.librarymanagement.dto.request.SignInRequest;
import semicolon.africa.librarymanagement.models.User;

public interface UserService {
    User loginIn(LoginRequest signUpRequest);
    User signUp(SignInRequest signInRequest);
    void resetPassword(ResetPasswordRequest resetPasswordRequest);
   // borrowBook()


}
