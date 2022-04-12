package com.Maventic.OCR.UserServices.Entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "user_profile")
public class User {

    @Id
    @Column(length = 255)
    private String userId;

    @Column(name = "api_password",length = 40,nullable = true)
    private String ApiPassword;

    @Column(name="company_id",length = 40,nullable = true)
    private String CompanyId;

    @Size(
            min = 3,
            max = 40,
            message = "First name size will between 3 to 40"
    )
    @Column(name = "first_name",length = 40,nullable = true)
    private String FirstName;

    @Size(
            min = 3,
            max = 40,
            message = "Last name size will between 3 to 40"
    )
    @Column(name = "last_name",length = 40,nullable = true)
    private String LastName;


    @Size(
            max = 255,
            message = "email address size can not be more then 255"
    )
    @Email(message = "Please enter proper Email address")
    @Column(name = "email", length = 40,nullable = false,unique = true)
    private String email;

    @Size(
            min = 10,
            max = 11,
            message = "Mobile no size have to be 10"
    )
    @Column(name = "contact_no",length = 11,nullable = false,unique = true)
    private String contactNo;

    @Size(
            min = 6,
            max = 15,
            message = "Password Size have to be between 6 to 15"
    )
    @Column(name = "password",length = 64,nullable = true)
    private String Password;

    @Column(name = "status",length = 2,nullable = true)
    private String Status;

    @NotBlank(message = "Please provide user role")
    @Column(name = "user_role",length = 2,nullable = true)
    private String UserRole;

    @Column(name = "created_date",length = 8,nullable = true)
    private Date CreatedDate;

    @Column(name = "Created_time",length = 8,nullable = true)
    private Time CreatedTime;

    @Column(name = "created_by",length = 40,nullable = true)
    private String CreatedBy;



//**************** all Constructor ***********************************************************

//    No parameterize constructor
    public User() {
    }

//    All parametrize constructor

    public User(String userId, String apiPassword, String companyId,
                String firstName, String lastName, String email,
                String contactNo, String password, String status,
                String userRole, Date createdDate, Time createdTime,
                String createdBy) {
        this.userId = userId;
        ApiPassword = apiPassword;
        CompanyId = companyId;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        Password = password;
        Status = status;
        UserRole = userRole;
        CreatedDate = createdDate;
        CreatedTime = createdTime;
        CreatedBy = createdBy;
    }


//**************** all getter and setter ***************************************************************************

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApiPassword() {
        return ApiPassword;
    }

    public void setApiPassword(String apiPassword) {
        ApiPassword = apiPassword;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String userRole) {
        UserRole = userRole;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public Time getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(Time createdTime) {
        CreatedTime = createdTime;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }


//**************** all To String ***************************************************************************


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", ApiPassword='" + ApiPassword + '\'' +
                ", CompanyId='" + CompanyId + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", Status='" + Status + '\'' +
                ", UserRole='" + UserRole + '\'' +
                ", CreatedDate=" + CreatedDate +
                ", CreatedTime=" + CreatedTime +
                ", CreatedBy='" + CreatedBy + '\'' +
                '}';
    }
}
