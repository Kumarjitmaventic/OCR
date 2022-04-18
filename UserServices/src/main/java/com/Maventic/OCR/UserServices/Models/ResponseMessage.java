package com.Maventic.OCR.UserServices.Models;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResponseMessage {
    private Date timeStamp;
    private HttpStatus httpStatus;
    private SuccessMessage successMessage;
    private Object body;


    public ResponseMessage() {
    }

    public ResponseMessage(SuccessMessage successMessage, List<Object> listObj) {
        this.successMessage = successMessage;
        List<Object> newListObj= listObj;
        timeStamp = new Date();
        httpStatus = HttpStatus.OK;
    }

    public ResponseMessage(SuccessMessage successMessage, Object body) {
        this.successMessage = successMessage;
       this.body = body;
        timeStamp = new Date();
        httpStatus = HttpStatus.OK;

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

    public SuccessMessage getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(SuccessMessage successMessage) {
        this.successMessage = successMessage;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "timeStamp=" + timeStamp +
                ", httpStatus=" + httpStatus +
                ", successMessage=" + successMessage +
                ", obj=" + body +
                '}';
    }
}
