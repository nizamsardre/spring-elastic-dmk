package com.dhamaka.pay.exception;

public class UnAuthorizeException extends DhamakaException{
    public UnAuthorizeException(String message) {
        super(message);
        this.setStatusCode(401);
    }
}
