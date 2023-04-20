package com.grocery.diff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BlinkItService {

    private  final RestTemplate restTemplate;

    @Value("${external.api.blink-it}")
    private String blinkItApi;

    public void getProduct(){
        HttpEntity<Object> request =  getObjectHttpEntity();
        ResponseEntity<Object> response=  restTemplate.exchange(blinkItApi+"?size=10&q=bread", HttpMethod.GET, request,Object.class);

    }

    private static HttpEntity<Object> getObjectHttpEntity() {
        return new HttpEntity<>(getHttpHeaders());
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("lat","12.8905808");
        headers.add("lon","77.6426413");
        return headers;
    }
}
