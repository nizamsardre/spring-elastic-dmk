package com.dhamaka.pay.util;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class DhamakaResponseErrorHandler extends DefaultResponseErrorHandler {


    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        int series = response.getRawStatusCode() / 100;
        return (series == 4 || series == 5);

    }
}