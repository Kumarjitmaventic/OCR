package com.Maventic.OCR.UserServices.Controller;

import com.Maventic.OCR.UserServices.Models.*;
import com.Maventic.OCR.UserServices.Entities.User;
import com.Maventic.OCR.UserServices.Services.UserService.UserAuthenticateServices;
import com.Maventic.OCR.UserServices.Services.UserService.UserServices;
import com.Maventic.OCR.UserServices.Utilities.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserRESTController {

    //Logger Object
    private final Logger Log = LoggerFactory.getLogger(UserRESTController.class);

    @Autowired
    private UserServices services;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthenticateServices userAuthenticateServices;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/hello")
    public String hello() throws Exception{
        return "hello";
    }

    @GetMapping("/user")
    public List<User> GetAllUser() throws Exception{
//        SuccessMessage successMessage = new SuccessMessage(services.GetAllUser());
        return services.GetAllUser();
    }

    @GetMapping("/user/{id}")
    public  ResponseEntity<ResponseMessage> GetUserById(@PathVariable("id") String userId) throws Exception {
            ResponseMessage responseMessage = new ResponseMessage(new SuccessMessage("Success"),services.GetUserById(userId));
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping("/user/email/{id}")
    public ResponseEntity<User> GetUserByEmail(@PathVariable("id") String userId) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(services.GetUserByEmail(userId));
    }

    @PostMapping("/user/new")
    public User CreateUser(@Valid @RequestBody User newUser)throws Exception{
        return services.CreateUser(newUser);
    }

    @PutMapping("/user/update/{id}")
    public User UpdateUser(@Valid @RequestBody User user,@PathVariable("id") String userId) throws Exception{
        return services.UpdateUser(user,userId);
    }

    @PutMapping("/user/update/password/{id}")
    public String UpdateUsersPassword(@Valid @RequestBody UpdatePasswordRequest updatePasswordRequest, @PathVariable("id") String userId) throws Exception{
        return services.UpdateUsersPassword(updatePasswordRequest,userId);
    }

    @PostMapping("/user/authenticate")
    public ResponseEntity<UserAuthenticateResponse> UserAuth(@Valid @RequestBody UserAuthenticateRequest userAuthenticateRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthenticateRequest.getUserName(), userAuthenticateRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw e;
        }

        final UserDetails userDetails = userAuthenticateServices.loadUserByUsername(userAuthenticateRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new UserAuthenticateResponse(jwt));
    }

}
