package com.Maventic.OCR.UserServices.Services.ActivityServices;

import com.Maventic.OCR.UserServices.Entities.ActivityLog;

import java.util.List;

public interface ActivityServices {

    public ActivityLog CreateActivityLog(ActivityLog activityLog) throws Exception;

    public List<ActivityLog> fetchActivityLogByCompany (String companyId) throws Exception;
}
