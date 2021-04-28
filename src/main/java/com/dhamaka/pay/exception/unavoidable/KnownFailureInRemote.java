package com.dhamaka.pay.exception.unavoidable;

public class KnownFailureInRemote extends Exception {

    public String fullResponse;

    public KnownFailureInRemote(String message, String fullResponse, Throwable cause) {
        super(message, cause);
        this.fullResponse = fullResponse;
    }

    public KnownFailureInRemote(String message, String fullResponse) {
        super(message);
        this.fullResponse = fullResponse;
    }
}