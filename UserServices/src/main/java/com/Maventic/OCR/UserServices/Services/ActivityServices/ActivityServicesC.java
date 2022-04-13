package com.Maventic.OCR.UserServices.Services.ActivityServices;

import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServicesC implements ActivityServices{
    @Override
    public ActivityLog CreateActivityLog(ActivityLog activityLog) throws Exception {
        return null;
    }

    @Override
    public List<ActivityLog> fetchActivityLogByCompany(String companyId) throws Exception {
        return null;
    }
}
