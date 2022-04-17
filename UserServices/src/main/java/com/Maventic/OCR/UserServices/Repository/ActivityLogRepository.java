package com.Maventic.OCR.UserServices.Repository;

import com.Maventic.OCR.UserServices.Entities.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ActivityLogRepository extends JpaRepository<ActivityLog,String> {

    @Query(value = "select * from activity_log where user_id = :userId",nativeQuery = true)
    public Optional<List<ActivityLog>> findByUser(String userId);
    public Optional<List<ActivityLog>> findByCompanyId(String companyId);
}
