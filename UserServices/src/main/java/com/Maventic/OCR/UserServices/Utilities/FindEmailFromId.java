package com.Maventic.OCR.UserServices.Utilities;

import com.Maventic.OCR.UserServices.Services.UserService.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FindEmailFromId {

    private String userId;

    @Autowired
    private UserServices userServices;

    public String getUserIdFromEmail(String email){
        return null;
    }
}

