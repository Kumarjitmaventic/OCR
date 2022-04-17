package com.Maventic.OCR.UserServices.Services.ActivityServices;

import com.Maventic.OCR.UserServices.CustomException.Exception.InternalServerError;
import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import com.Maventic.OCR.UserServices.Repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class ActivityServicesC implements ActivityServices{
    long now = System.currentTimeMillis();

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Override
    public ActivityLog CreateActivityLog(ActivityLog activityLog) throws Exception {
        activityLog.setDate(new Date(now));
        activityLog.setTime(new Time(now));

        ActivityLog newActivityLog = activityLogRepository.save(activityLog);

        if(newActivityLog==null)
            throw new InternalServerError("Internal services Error while creating Activity Log");
        else
            return newActivityLog;
    }

    @Override
    public List<ActivityLog> fetchActivityLogByCompany(String companyId) throws Exception {
        return activityLogRepository.findByCompanyId(companyId).get();
    }

    @Override
    public List<ActivityLog> fetchActivityLogByUser(String userId) throws Exception {
        return activityLogRepository.findByUser(userId).get();
    }
}
