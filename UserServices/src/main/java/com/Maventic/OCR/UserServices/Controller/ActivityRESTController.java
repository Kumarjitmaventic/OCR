package com.Maventic.OCR.UserServices.Controller;

import com.Maventic.OCR.UserServices.CustomException.Exception.BadRequestException;
import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import com.Maventic.OCR.UserServices.Services.ActivityServices.ActivityServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ActivityRESTController {

    //Logger Object
    private final Logger Log = LoggerFactory.getLogger(UserRESTController.class);

    @Autowired
    private ActivityServices services;

    @PostMapping("/user/new/activityLog")
    public ActivityLog CreateActivityLog(@Valid @RequestBody ActivityLog activityLog) throws Exception{
        return services.CreateActivityLog(activityLog);
    }

    @GetMapping("/user/get/activityLog")
    public List<ActivityLog> GetActivityLog(@RequestParam("companyId") Optional<String> companyId, @RequestParam("userId") Optional<String> userId) throws Exception{
//        return services.fetchActivityLogByCompany(companyId);

        if(userId.isPresent()){
            return services.fetchActivityLogByCompany(userId.get());
        }
        else if(companyId.isPresent()){
            return services.fetchActivityLogByCompany(companyId.get());
        }
        else
            throw new BadRequestException("Please provide filter option");
    }

}
