package com.Maventic.OCR.UserServices.Models;

import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import com.Maventic.OCR.UserServices.Entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;



public class SuccessMessage {


    ArrayList<Object> objects = new ArrayList<Object>();

    private UserAuthenticateResponse userAuthenticateResponse;

    public SuccessMessage(Object o) {
        objects.add(o);
    }




}
