package com.dhamaka.pay.exception;

public class Non200Exception extends DhamakaException {
    public Non200Exception(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
