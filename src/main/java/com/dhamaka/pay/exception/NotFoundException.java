package com.dhamaka.pay.exception;

import lombok.Data;

@Data
public class NotFoundException extends DhamakaException {
    public NotFoundException(String message) {
        super(message);
        this.setStatusCode(404);
    }
}
