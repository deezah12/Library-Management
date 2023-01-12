package semicolon.africa.librarymanagement.service.inter;

import semicolon.africa.librarymanagement.dto.request.ForgotPasswordRequest;
import semicolon.africa.librarymanagement.models.User;

public interface EmailService {
    void sendUserRegistrationConfirmEmail(User user);
    void sendForgotPasswordEmail(ForgotPasswordRequest forgotPasswordRequest);
}
