package semicolon.africa.librarymanagement.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.librarymanagement.dto.request.LoginRequest;
import semicolon.africa.librarymanagement.dto.request.ResetPasswordRequest;
import semicolon.africa.librarymanagement.dto.request.SignInRequest;
import semicolon.africa.librarymanagement.exceptions.EmailExistException;
import semicolon.africa.librarymanagement.exceptions.InvalidPasswordException;
import semicolon.africa.librarymanagement.exceptions.UserNotFoundException;
import semicolon.africa.librarymanagement.models.User;
import semicolon.africa.librarymanagement.repositories.UserJpa;
import semicolon.africa.librarymanagement.service.inter.UserService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpa userJpa;

    @Override
    public User signUp(SignInRequest signInRequest) {
        User user = new User();
        var foundEmail = userJpa.findByEmail(signInRequest.getEmail());
        if (!Objects.equals(user.getEmail(), null)) throw  new EmailExistException(String.format("User %s email already exist",foundEmail ));
        else {
            user.setFirstName(signInRequest.getFirstName());
            user.setLastName(signInRequest.getLastName());
            user.setEmail(signInRequest.getEmail());
            user.setPassword(hashPassword(signInRequest.getPassword()));
            userJpa.save(user);
        }

        return user;
    }

    @Override
    public void resetPassword(ResetPasswordRequest passwordRequest) {
        User user = userJpa.findByUserId(passwordRequest.getId());
        user.setPassword(hashPassword(passwordRequest.getPassword()));
        userJpa.save(user);
    }

    @Override
    public User loginIn(LoginRequest loginRequest) {
        var foundUser = userJpa.findByEmail(loginRequest.getEmail());
        if (Objects.isNull(foundUser)) throw new UserNotFoundException("user does not exist");
        if (!BCrypt.checkpw(loginRequest.getPassword(), foundUser.getPassword())) {
            throw  new InvalidPasswordException("password does not match");
        }
        return foundUser;
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


}
