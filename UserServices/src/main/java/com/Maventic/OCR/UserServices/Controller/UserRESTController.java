package com.Maventic.OCR.UserServices.Controller;

import com.Maventic.OCR.UserServices.Beans.UserPassword;
import com.Maventic.OCR.UserServices.Entities.User;
import com.Maventic.OCR.UserServices.Services.UserService.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserRESTController {

    //Logger Object
    private final Logger Log = LoggerFactory.getLogger(UserRESTController.class);

    @Autowired
    private UserServices services;

    @GetMapping("/user")
    public List<User> GetAllUser() throws Exception{
        return services.GetAllUser();
    }

    @GetMapping("/user/{id}")
    public  User GetUserById(@PathVariable("id") String userId) throws Exception {

        return services.GetUserById(userId);
    }

    @GetMapping("/user/email/{id}")
    public  User GetUserByEmail(@PathVariable("id") String userId) throws Exception {

        return services.GetUserByEmail(userId);
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
    public String UpdateUsersPassword(@Valid @RequestBody UserPassword userPassword, @PathVariable("id") String userId) throws Exception{
        return services.UpdateUsersPassword(userPassword,userId);
    }

}
