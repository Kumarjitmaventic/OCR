package com.Maventic.OCR.UserServices.Models;

import org.springframework.stereotype.Component;


public class SuccessMessage {

    private String message;
//    private String OtherMessage;

    public SuccessMessage() {
    }

//    public SuccessMessage(String message, String otherMessage) {
//        this.message = message;
//        OtherMessage = otherMessage;
//    }

    public SuccessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public String getOtherMessage() {
//        return OtherMessage;
//    }
//
//    public void setOtherMessage(String otherMessage) {
//        OtherMessage = otherMessage;
//    }

    @Override
    public String toString() {
        return "SuccessMessage{" +
                "message='" + message + '\'' +
//                ", OtherMessage='" + OtherMessage + '\'' +
                '}';
    }
}
