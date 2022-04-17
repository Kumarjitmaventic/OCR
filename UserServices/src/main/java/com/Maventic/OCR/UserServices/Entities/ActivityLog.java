package com.Maventic.OCR.UserServices.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity(name ="activity_log")
@Table(name = "activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "activity_id", length = 40)
    private String activityId;

    @Column(name = "company_id",length = 40,nullable = false)
    private String companyId;

    @Column(name = "date",nullable = false)
    private Date date;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId"
    )
    private User user;

    @Column(name = "Time",nullable = false)
    private Time time;

    @Column(name = "activity_type",nullable = false)
    private String activityType;

    @Column(name = "ip",nullable = true)
    private String ip;


    //**************** all constructor ***************************************************************************


    public ActivityLog() {
    }

    public ActivityLog(String activityId, String companyId, Date date, User user, Time time, String activityType, String ip) {
        this.activityId = activityId;
        this.companyId = companyId;
        this.date = date;
        this.user = user;
        this.time = time;
        this.activityType = activityType;
        this.ip = ip;
    }

    public ActivityLog(String companyId, User user, String activityType, String ip) {
        this.companyId = companyId;
        this.user = user;
        this.activityType = activityType;
        this.ip = ip;
    }

    //**************** all getter and setter ***************************************************************************
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    //**************** To String ***************************************************************************

    @Override
    public String toString() {
        return "ActivityLog{" +
                "activityId='" + activityId + '\'' +
                ", customerId='" + companyId + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", time=" + time +
                ", activityType='" + activityType + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}

