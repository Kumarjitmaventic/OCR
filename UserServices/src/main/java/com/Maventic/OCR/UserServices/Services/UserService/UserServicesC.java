package com.Maventic.OCR.UserServices.Services.UserService;

import com.Maventic.OCR.UserServices.Models.UpdatePasswordRequest;
import com.Maventic.OCR.UserServices.CustomException.Exception.InternalServerError;
import com.Maventic.OCR.UserServices.CustomException.Exception.WrongValueException;
import com.Maventic.OCR.UserServices.Entities.User;
import com.Maventic.OCR.UserServices.CustomException.Exception.UserNotFoundException;
import com.Maventic.OCR.UserServices.Repository.UserRepository;
import com.Maventic.OCR.UserServices.Utilities.CreateActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Service
public class UserServicesC implements UserServices{

    private Random random = new Random();
    long now = System.currentTimeMillis();

    //Logger Object
    private final Logger Log = LoggerFactory.getLogger(UserServicesC.class);

    //Utilities Create Activity object for create Activity log  ##autometion
    @Autowired
    private CreateActivity createActivity;

    // Creating User Services
    @Autowired
    private UserRepository userRepository;

    public UserServicesC(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> GetAllUser() {
        return userRepository.findAll();
    }


    @Override
    public User GetUserById(String userId) throws UserNotFoundException {
        Optional<User> user  = userRepository.findById(userId);

        if (!user.isPresent()){
            throw  new UserNotFoundException("User Not found with Id " + userId);
        }

        else
            return user.get();
    }

    @Override
    public User CreateUser(User newUser) throws Exception {
        boolean activityCreationStatus = true;

        // creating random user id
        try{
            int randomNumber = random.nextInt(1000);
            String userID = Integer.toString(randomNumber);

            newUser.setUserId(userID);
            newUser.setCreatedDate(new Date(now));
            newUser.setCreatedTime(new Time(now));
            User user = userRepository.save(newUser);
            if (user!=null){
                createActivity.createNew(user,"01","");
                return user;
            }
            else
                throw new InternalServerError("User creating error. Please contact with admin");

        }
        catch (Exception exception){
            throw exception;
        }


    }

    @Override
    public User UpdateUser(User user, String emailId) throws Exception {

        // getting user details
        User oldUser;

        try {
           Optional<User> fetchedUser = userRepository.findByEmail(emailId);
            if(fetchedUser.isPresent()){
                oldUser = fetchedUser.get();
            }
            else
                throw new UserNotFoundException("User not found against "+ emailId+" this Email");
        }
        catch (Exception exception){
            throw exception;
        }

        // updating new data
        if(Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())){
            oldUser.setFirstName(user.getFirstName());
        }
        if(Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())){
            oldUser.setLastName(user.getLastName());
        }
        if(Objects.nonNull(user.getCompanyId()) && !"".equalsIgnoreCase(user.getCompanyId())){
            oldUser.setCompanyId(user.getCompanyId());
        }

//        if(Objects.nonNull(user.getUserRole()) && !"".equalsIgnoreCase(user.getUserRole())){
//            oldUser.setUserRole(user.getUserRole());
//        }
        if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())){
            oldUser.setEmail(user.getEmail());
        }
        if(Objects.nonNull(user.getContactNo()) && !"".equalsIgnoreCase(user.getContactNo())){
            oldUser.setContactNo(user.getContactNo());
        }
        if(Objects.nonNull(user.getStatus()) && !"".equalsIgnoreCase(user.getStatus())){
            oldUser.setStatus(user.getStatus());
        }
        if(Objects.nonNull(user.getCreatedBy()) && !"".equalsIgnoreCase(user.getCreatedBy())){
            oldUser.setCreatedBy(user.getCreatedBy());
        }

        User updatedUser;
        try {
            updatedUser = userRepository.save(oldUser);
            if (createActivity!=null){
                createActivity.createNew(updatedUser,"02","");
                return updatedUser;
            }
            else
                throw new InternalServerError("User creating error. Please contact with admin");
        }
        catch (Exception exception){
            throw exception;
        }

    }

    @Override
    public String UpdateUsersPassword(UpdatePasswordRequest updatePasswordRequest, String userId) throws Exception {
        User userOldData = userRepository.findById(userId).get();

        if(userOldData!=null && userOldData.getPassword().equals(updatePasswordRequest.getOldPassword())){
            userOldData.setPassword(updatePasswordRequest.getNewPassword());
        }
        else if (updatePasswordRequest.getOldPassword().equals(updatePasswordRequest.getNewPassword())){
            throw new WrongValueException("Please provide correct Password", new Throwable("Old password and New password can not be same"));
        }
        else {
            throw new WrongValueException("Please provide correct Password", new Throwable("Old password is wrong"));
//            return "Please enter correct Password";
        }

        User updatedUser;
        try {
            updatedUser = userRepository.save(userOldData);
            if (createActivity!=null){
                createActivity.createNew(updatedUser,"03","");
                return "Success";
            }
            else
                throw new InternalServerError("User creating error. Please contact with admin");
        }
        catch (Exception exception){
            throw exception;
        }
    }

    @Override
    public User GetUserByEmail(String email) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()){
            throw new UserNotFoundException("No account with this Email.");
        }
        else
            return user.get();
    }

}
