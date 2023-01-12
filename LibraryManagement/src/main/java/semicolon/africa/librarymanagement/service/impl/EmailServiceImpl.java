package semicolon.africa.librarymanagement.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import semicolon.africa.librarymanagement.dto.request.ForgotPasswordRequest;
import semicolon.africa.librarymanagement.models.User;
import semicolon.africa.librarymanagement.service.inter.EmailService;
@Service
public class EmailServiceImpl implements EmailService {


   @Autowired
   JavaMailSender mailSender;

    @Override
    public void sendUserRegistrationConfirmEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Library portal registration");
        message.setText(this.userRegistrationConfirmEmailText(user));
        mailSender.send(message);


    }

    private String userRegistrationConfirmEmailText(User user) {

        return "Hello " + user.getFirstName() + " "+ user.getLastName()+ ","
                + "\nThank you for registering to our Library Portal. From now on you have access to enormous amount of books with just few clicks."
                + "\n\nHave a nice day,"
                + "\nLibrary Portal Team";
    }


    @Override
    public void sendForgotPasswordEmail(ForgotPasswordRequest forgotPasswordRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(forgotPasswordRequest.getUser().getEmail());
        message.setSubject("Reset Password");
        message.setText(this.prepareForgotPasswordEmail(forgotPasswordRequest));
        mailSender.send(message);

    }

    private String prepareForgotPasswordEmail(ForgotPasswordRequest forgotPasswordRequest) {
        String url = forgotPasswordRequest.getPath() + "?userId=" + forgotPasswordRequest.getUser().getUserId() + "&token=" + forgotPasswordRequest.getToken();

        return "Hello " + forgotPasswordRequest.getUser().getFirstName() + " " + forgotPasswordRequest.getUser().getLastName() + " ,"
                + "\n\nWe have receive your request for resetting password to your account into our Library Portal"
                + "\n\n If you have not requested it please let us know immediately."
                + "\n Here is your personal link to a page where you can reset your password: "
                + "\n\n" + url;
    }
}

