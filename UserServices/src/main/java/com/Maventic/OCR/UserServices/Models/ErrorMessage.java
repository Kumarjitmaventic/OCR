package com.Maventic.OCR.UserServices.Models;

public class ErrorMessage {
    private String message;
    private String messageCause;
    private String messageDescription;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageCause() {
        return messageCause;
    }

    public void setMessageCause(String messageCause) {
        this.messageCause = messageCause;
    }

    public ErrorMessage() {
    }
    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(String message, String messageCause) {
        this.message = message;
        this.messageCause = messageCause;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", messageCause='" + messageCause + '\'' +
                '}';
    }
}
