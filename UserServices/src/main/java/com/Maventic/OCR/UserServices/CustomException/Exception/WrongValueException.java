package com.Maventic.OCR.UserServices.CustomException.Exception;

public class WrongValueException extends Exception {
    public WrongValueException() {
        super();
    }

    public WrongValueException(String message) {
        super(message);
    }

    public WrongValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongValueException(Throwable cause) {
        super(cause);
    }

    protected WrongValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
