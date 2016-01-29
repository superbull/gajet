package com.kasiniu.exception;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
public class ErrorInfo {
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorInfo(String message) {
        this.message = message;
    }
}
