package com.Maventic.OCR.UserServices.Utilities;

import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import com.Maventic.OCR.UserServices.Entities.User;
import com.Maventic.OCR.UserServices.Services.ActivityServices.ActivityServices;
import com.Maventic.OCR.UserServices.Services.UserService.UserServicesC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Hashtable;


@Controller
public class CreateActivity  {
    private final Logger Log = LoggerFactory.getLogger(CreateActivity.class);

    // creating Hashtable to store activity type
    HashMap<String,String> activityLogType=new HashMap<String,String>();

    // creating variable to create activity services from here
    @Autowired
    private ActivityServices activityServices;

    // creation status flag ti check activity created or not
    private boolean creationStatus;

    public CreateActivity() {
        activityLogType.put("01","Create");
        activityLogType.put("02","Update");
        activityLogType.put("03","Password Change");
    }

    public boolean createNew(User user,String activityType,String ip){
        // creating new activityLog type to create new one
        ActivityLog activityLog = new ActivityLog(user.getCompanyId(),user,activityType,ip);
        try {
            ActivityLog newActivityLog = activityServices.CreateActivityLog(activityLog);
            creationStatus = true; // setting status flag
        }
        catch (Exception e){
            Log.error(e.getLocalizedMessage());
            creationStatus = false; // setting status flag
        }
        finally {
            if(creationStatus){
                Log.info(" New Activity Created Against Id : " + user.getEmail() +". Activity Type : "+activityLogType.get(activityType));
                return true;
            }
            else
                Log.error(" New Activity Creation fail Against Id : " + user.getEmail() +". Activity Type : "+activityLogType.get(activityType));
            return false;
        }

    }
}
