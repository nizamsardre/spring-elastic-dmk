package com.dhamaka.pay.exception.unavoidable;

public class UnknownResultFromRemote extends Exception {

    public String fullResponse;

    public UnknownResultFromRemote(String message, String fullResponse, Throwable cause) {
        super(message, cause);
        this.fullResponse = fullResponse;
    }

    public UnknownResultFromRemote(String message, String fullResponse) {
        super(message);
        this.fullResponse = fullResponse;
    }
}