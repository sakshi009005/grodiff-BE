package com.grocery.diff.service;

import com.grocery.diff.model.BigBasketResponse;
import com.grocery.diff.model.BlinkItResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BigbasketService {

    @Value("${external.api.big-basket}")
    private String bigBasketUrl;

    @Value("${external.user-agent}")
    public String userAgent;

    private final RestTemplate restTemplate;

    public void getProduct(String query) {
        HttpEntity<Object> request = getObjectHttpEntity();


        ResponseEntity<BigBasketResponse> response = restTemplate.exchange(String.format("%s%s%s", bigBasketUrl,"?type=deck&slug=",query),
                HttpMethod.GET, request, BigBasketResponse.class);
        //BlinkItResponse object= (BlinkItResponse) response.getBody();
    }

    private HttpEntity<Object> getObjectHttpEntity() {
        return new HttpEntity<>(getHttpHeaders());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("user-agent", userAgent);
        headers.set("Cookie", "_bb_locSrc=default; _bb_vid=\"NzUyODY3NjQ4MA==\"; _bb_tc=0; _bb_rdt=\"MzExMjQ3MjI1MQ==.0\"; _bb_rd=6; sessionid=zwx9fuig2hppadhxw9533dbfja2ea89w; jarvis-id=274683c4-12a8-4338-8629-2fdef5598541; adb=0; _gid=GA1.2.1258892374.1681989081; bigbasket.com=f837b833-f89c-48a9-8d41-b288d1b0ed6a; _gcl_au=1.1.1461996847.1681989082; bbscc=2; jedi=2; _fbp=fb.1.1681989083557.884015661; ufi=1; _client_version=2660; _gac_UA-27455376-1=1.1682007551.CjwKCAjwov6hBhBsEiwAvrvN6JubqCFz5Tn2LCrciU3Op0JecR8I-6SSWDyX2g6Fa9xsYBnit2jBdBoC3ygQAvD_BwE; _gcl_aw=GCL.1682007552.CjwKCAjwov6hBhBsEiwAvrvN6JubqCFz5Tn2LCrciU3Op0JecR8I-6SSWDyX2g6Fa9xsYBnit2jBdBoC3ygQAvD_BwE; _clck=iaymz9|1|fay|0; csurftoken=o3Uvzw.NzUyODY3NjQ4MA==.1682062958473.yh6KLh8hg1M2k5gAPaYEt+solTrOK50v7DaLc3rW12g=; csrftoken=gEVC3V9izXRMc7yZd1QvevMZq4woHDfR9ni5xKJhRiyQ2B7lQ9c2mhAC9HjzohvM; _ga=GA1.1.1127403394.1681989081; _clsk=ynsxjz|1682063211578|4|1|r.clarity.ms/collect; _bb_cid=27; _bb_aid=\"Mjk2NDE4OTUxNQ==\"; _bb_hid=3089; ts=\"2023-04-21 13:24:38.023\"; _ga_FRRYG5VKHX=GS1.1.1682063064.5.1.1682063782.60.0.0");
        return headers;
    }
}
