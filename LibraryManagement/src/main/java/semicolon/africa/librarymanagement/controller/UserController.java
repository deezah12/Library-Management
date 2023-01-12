package semicolon.africa.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.librarymanagement.dto.request.LoginRequest;
import semicolon.africa.librarymanagement.dto.request.ResetPasswordRequest;
import semicolon.africa.librarymanagement.dto.request.SignInRequest;
import semicolon.africa.librarymanagement.dto.response.ApiResponse;
import semicolon.africa.librarymanagement.service.inter.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> create(@RequestBody SignInRequest signInRequest){
       var buildUser = userService.signUp(signInRequest);
        return  new ResponseEntity<>(new ApiResponse(true, buildUser), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public  ResponseEntity<?> CheckIn(@RequestBody LoginRequest loginRequest){
        var rebuildUser =userService.loginIn(loginRequest);
        return new ResponseEntity<>(new ApiResponse(true, rebuildUser), HttpStatus.OK);
    }
    @PatchMapping("/reset")
    public  ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        userService.resetPassword(resetPasswordRequest);
        return new ResponseEntity<>(new ApiResponse(true), HttpStatus.ACCEPTED);
    }
}
