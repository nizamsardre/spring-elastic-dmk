package com.dhamaka.pay.exception;

public class BadRequestException extends DhamakaException {
    public BadRequestException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
