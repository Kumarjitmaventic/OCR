package com.Maventic.OCR.UserServices.Repository;

import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLog,String> {
}
