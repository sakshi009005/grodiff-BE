package com.grocery.diff.service;

import com.grocery.diff.exception.ProductNotFetchedException;
import com.grocery.diff.model.BigBasketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BigbasketService extends GrodiffService {

    private final RestTemplate restTemplate;
    @Value("${external.api.big-basket}")
    private String bigBasketUrl;

    @Value("${external.cookie.big-basket-url}")
    private String bigBasketUrlForCookie;

    public ResponseEntity<BigBasketResponse> getProduct(String query) throws IOException {

        return restTemplate.exchange(String.format("%s%s%s", bigBasketUrl, "?type=deck&page=20&slug=", query), HttpMethod.GET, getObjectHttpEntity(CookieService.showCookies(bigBasketUrlForCookie), null, null), BigBasketResponse.class);

    }
}
