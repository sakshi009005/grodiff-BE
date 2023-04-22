package com.grocery.diff.service;

import com.grocery.diff.model.BlinkItResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BlinkItService extends GrodiffService {

    private final RestTemplate restTemplate;
    @Value("${external.api.blink-it}")
    private String blinkItApi;

    @Value("${external.cookie.blink-it-cookie}")
    private String blinkItCookie;

    public ResponseEntity<BlinkItResponse> getProduct(String query, String longitude, String latitude) {

        return restTemplate.exchange(String.format("%s%s%s", blinkItApi, "?start=0&size=-1&search_type=7&q=", query),
                HttpMethod.GET, getObjectHttpEntity(blinkItCookie, longitude, latitude), BlinkItResponse.class);
    }
}
