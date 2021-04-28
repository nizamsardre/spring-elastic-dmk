package com.dhamaka.pay.exception;


import org.apache.http.HttpStatus;

public class InternalIOException extends DhamakaException {
    public InternalIOException() {
        super("Internal error");
        this.statusCode = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    }
}
