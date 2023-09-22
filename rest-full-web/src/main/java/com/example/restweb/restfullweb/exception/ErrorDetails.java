package com.example.restweb.restfullweb.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timeStamp, String message, String description) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp.atStartOfDay();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
