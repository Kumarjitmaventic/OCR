package com.Maventic.OCR.UserServices.Services;

import com.Maventic.OCR.UserServices.Beans.UserPassword;
import com.Maventic.OCR.UserServices.Entities.User;

import java.util.List;


public interface UserServices {
    // get All User
    public List<User> GetAllUser() throws Exception;

    // get user by id
    public User GetUserById(String userId) throws Exception;

    // Create new user
    public  User CreateUser(User newUser) throws Exception;

    // update user details
    public  User UpdateUser(User user, String userId) throws Exception;

    //update user Password
    public String UpdateUsersPassword(UserPassword userPassword,String userId) throws Exception;

    //email User by Email
    public User GetUserByEmail(String email) throws Exception;

}
