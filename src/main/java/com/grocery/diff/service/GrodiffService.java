package com.grocery.diff.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Objects;

public class GrodiffService {

    @Value("${external.user-agent}")
    public String userAgent;

    public HttpEntity<Object> getObjectHttpEntity(String cookie, String longitude, String latitude) {
        return new HttpEntity<>(getHttpHeaders(cookie,longitude,latitude));
    }

    public HttpHeaders getHttpHeaders(String cookie, String longitude, String latitude) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("user-agent", userAgent);
        headers.set("Cookie", cookie);
        populateLocation(longitude, latitude, headers);
        return headers;
    }

    private void populateLocation(String longitude, String latitude, HttpHeaders headers) {
        if (Objects.nonNull(latitude)) {
            headers.set("lat", latitude);
        }
        if (Objects.nonNull(longitude)) {
            headers.set("lon", longitude);
        }
    }
}
