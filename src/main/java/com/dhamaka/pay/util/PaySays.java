package com.dhamaka.pay.util;

import com.dhamaka.pay.dto.SimpleMessageResponseREST;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Slf4j
public class PaySays {

    public static void prepareSuccessResponse(String statusMessage, SimpleMessageResponseREST message) {
        message.message = statusMessage;
        log.debug("Pay says: " + statusMessage);
    }

    public static void ok(DeferredResult<ResponseEntity<SimpleMessageResponseREST>> result, SimpleMessageResponseREST message, String responseMessage) {
        prepareSuccessResponse(responseMessage, message);
        ResponseEntity<SimpleMessageResponseREST> response = new ResponseEntity<>(message, HttpStatus.OK);
        result.setResult(response);
    }

    public static void ok(DeferredResult<ResponseEntity<SimpleMessageResponseREST>> result, SimpleMessageResponseREST message) {
        ok(result, message, "Operation Successful");
    }

    public static void redirect(DeferredResult<ResponseEntity<SimpleMessageResponseREST>> result, String redirectUrl) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI(redirectUrl));
            ResponseEntity<SimpleMessageResponseREST> responseEntity = new ResponseEntity<>(headers, HttpStatus.FOUND);

            result.setResult(responseEntity);

        } catch (URISyntaxException e) {
            log.error("URISyntaxException", e);
        }

    }
    public static void redirect(DeferredResult<ResponseEntity<SimpleMessageResponseREST>> result,
                                String redirectUrl,
                                Map<String, String> queryParams) {

        if (queryParams == null || queryParams.isEmpty()) {
            redirect(result, redirectUrl);
            return;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(RestUtils.getFullURI(redirectUrl, queryParams));
        ResponseEntity<SimpleMessageResponseREST> responseEntity = new ResponseEntity<>(headers, HttpStatus.FOUND);

        result.setResult(responseEntity);
    }
}
