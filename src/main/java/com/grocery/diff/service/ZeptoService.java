package com.grocery.diff.service;

import com.grocery.diff.model.ZeptoRequest;
import com.grocery.diff.model.ZeptoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ZeptoService extends GrodiffService {

    private final RestTemplate restTemplate;

    @Value("${external.api.zepto}")
    private String zeptoUrl;

    @Value("${external.cookie.zepto-cookie}")
    private String zeptoCookie;

    public ResponseEntity<ZeptoResponse> getProduct(ZeptoRequest zeptoRequest) {
        HttpEntity<Object> request = getObjectHttpEntity(zeptoRequest);

        return restTemplate.exchange(zeptoUrl, HttpMethod.POST, request, ZeptoResponse.class);
    }

    private HttpEntity<Object> getObjectHttpEntity(ZeptoRequest zeptoRequest) {
        return new HttpEntity<>(zeptoRequest, getHttpHeaders());
    }

    private HttpHeaders getHttpHeaders() {

        HttpHeaders headers = super.getHttpHeaders(zeptoCookie, null, null);
        headers.set("storeId", getStoreId());
        return headers;
    }

    private String getStoreId() {
        String storeId = "";
        if (Objects.nonNull(zeptoCookie)) {
            String[] cookies = zeptoCookie.split(";");
            for (String cookie : cookies) {
                if (cookie.contains("store_id")) {
                    storeId = cookie.substring(cookie.indexOf("=") + 1);
                }
            }
        }
        return storeId;
    }
}
