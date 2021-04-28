package com.dhamaka.pay.exception;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DhamakaException extends RuntimeException{
    public Integer statusCode;
    public DhamakaException(String message) {
        super((message));
    }
}
