package com.Maventic.OCR.UserServices.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserAuthenticateRequest {
    @Email(message = "Please provide proper email.")
    private String userName;

    @Size(
            min = 6,
            max = 15,
            message = "Password must be 6-15 character."
    )
    private String password;

    public UserAuthenticateRequest() {
    }

    public UserAuthenticateRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
