package com.dhamaka.pay.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class SimpleMessageResponseREST implements Serializable {
    public String message;
    public Integer statusCode;
}
