package com.Maventic.OCR.UserServices.Models;

import javax.validation.constraints.Size;

public class UserPassword {
    @Size(
            min = 6,
            max = 15,
            message = "Password Size have to be between 6 to 15"
    )
   private String OldPassword;

    @Size(
            min = 6,
            max = 15,
            message = "Password Size have to be between 6 to 15"
    )
   private String NewPassword;

    public UserPassword() {
    }

    public UserPassword(String oldPassword, String newPassword) {

        OldPassword = oldPassword;
        NewPassword = newPassword;
    }

    public String getOldPassword() {
        return OldPassword;
    }

    public void setOldPassword(String oldPassword) {
        OldPassword = oldPassword;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String newPassword) {
        NewPassword = newPassword;
    }

}
