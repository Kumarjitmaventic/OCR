package com.Maventic.OCR.UserServices.Models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Date;


public class HttpResponseMessage {
   private Date timeStamp;
   private HttpStatus httpStatus;

   @Autowired
   private ErrorMessage message;

   private String path;


    public HttpResponseMessage() {
        this.timeStamp = new Date();
    }


    public HttpResponseMessage(Date timeStamp, HttpStatus httpStatus, ErrorMessage message, String path) {
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
        this.message = message;
        this.path = path;

    }

    public HttpResponseMessage(HttpStatus httpStatus, ErrorMessage message, String path) {
        this.timeStamp = new Date();
        this.httpStatus = httpStatus;
        this.message = message;
        this.path = path;

    }
    public HttpResponseMessage(HttpStatus httpStatus, ErrorMessage message) {
        this.timeStamp = new Date();
        this.httpStatus = httpStatus;
        this.message =  message;
        this.path = "";
    }


    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ErrorMessage getMessage() {
        return message;
    }

    public void setMessage(ErrorMessage message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return "HttpResponseMessage{" +
                "timeStamp=" + timeStamp +
                ", status=" + httpStatus +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
