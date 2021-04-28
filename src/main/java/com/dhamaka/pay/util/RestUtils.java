package com.dhamaka.pay.util;

import com.dhamaka.pay.dto.BasicRestResponse;
import com.dhamaka.pay.exception.DhamakaException;
import com.dhamaka.pay.exception.InternalIOException;
import com.dhamaka.pay.exception.Non200Exception;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientResponseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Slf4j
public class RestUtils {
    public static final int VALID_OTP_EXISTS = 452;

    public static DhamakaException generateAppropriateException(RestClientResponseException e) {
        if (e.getRawStatusCode() / 100 == 5) { // is 5xx error

            log.error("Remote internal error", e);
            return new InternalIOException();

        } else {

            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            try {

                BasicRestResponse response = mapper.readValue(e.getResponseBodyAsString(), BasicRestResponse.class);

                return new Non200Exception(response.message, e.getRawStatusCode());

            } catch (IOException e1) {
                log.error("Error parsing response: ", e1);
                throw new InternalIOException();
            }
        }
    }

    public static URI getFullURI(String url) {
        try {
            URIBuilder builder = new URIBuilder(url);
            return builder.build();
        } catch (URISyntaxException e) {
            log.error("URISyntaxException", e);
        }
        throw new InternalIOException();
    }

    public static URI getFullURI(String url, Map<String, String> queryParams) {
        try {
            URIBuilder builder = new URIBuilder(url);
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                builder.addParameter(key, value);
            }

            return builder.build().toURL().toURI();

        } catch (URISyntaxException e) {
            log.error("URISyntaxException", e);
        } catch (MalformedURLException e) {
            log.error("MalformedURLException", e);
        }
        throw new InternalIOException();
    }
}
