package com.Maventic.OCR.UserServices.Models;

import org.hibernate.mapping.Any;

public class SuccessMessage {
    private String message;
    private Any obj;

    public SuccessMessage(String message,Any obj) {
        this.message = message;
        this.obj = obj;
    }
}
