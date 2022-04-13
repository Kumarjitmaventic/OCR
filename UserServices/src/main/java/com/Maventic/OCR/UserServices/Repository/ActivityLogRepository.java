package com.Maventic.OCR.UserServices.Repository;

import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityLogRepository extends JpaRepository<ActivityLog,String> {

    public Optional<List<ActivityLog>> findByUser(String userId);
}
