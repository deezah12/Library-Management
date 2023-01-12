package semicolon.africa.librarymanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.librarymanagement.dto.request.SignInRequest;
import semicolon.africa.librarymanagement.service.inter.UserService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Test
    void signUp() {
        SignInRequest signIn = new SignInRequest();
        signIn.setFirstName("Habeeb");
        signIn.setLastName("Musa");
        signIn.setEmail("habeeb@gmail.com");
        signIn.setPassword("Habeed2020$");
        userService.signUp(signIn);
        var signInResponse = userService.signUp(signIn);
        assertEquals("successful", signInResponse.getMessage());

    }

    @Test
    void loginIn() {
    }
}