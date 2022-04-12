package com.Maventic.OCR.UserServices.Beans;


import org.springframework.http.HttpStatus;

import java.util.Date;


public class HttpResponseMessage {
   private Date timeStamp;
   private HttpStatus status;
   private String message;
   private String path;
   private String messageDescription;

    public HttpResponseMessage() {
        this.timeStamp = new Date();
    }


    public HttpResponseMessage(Date timeStamp, HttpStatus status, String message, String path, String messageDescription) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.messageDescription = messageDescription;
    }

    public HttpResponseMessage( HttpStatus status, String message, String path, String messageDescription) {
        this.timeStamp = new Date();
        this.status = status;
        this.message = message;
        this.path = path;
        this.messageDescription = messageDescription;
    }
    public HttpResponseMessage( HttpStatus status, String message) {
        this.timeStamp = new Date();
        this.status = status;
        this.message = message;
        this.path = "";
        this.messageDescription = "";
    }


    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    @Override
    public String toString() {
        return "HttpResponseMessage{" +
                "timeStamp=" + timeStamp +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", messageDescription='" + messageDescription + '\'' +
                '}';
    }
}
