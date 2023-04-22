package com.grocery.diff.service;

import com.grocery.diff.model.ZeptoRequest;
import com.grocery.diff.model.ZeptoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ZeptoService {

    private final RestTemplate restTemplate;
    @Value("${external.user-agent}")
    public String userAgent;
    @Value("${external.api.zepto}")
    private String zeptoUrl;

    public ResponseEntity<ZeptoResponse> getProduct(ZeptoRequest zeptoRequest) {
        HttpEntity<Object> request = getObjectHttpEntity(zeptoRequest);

        return restTemplate.exchange(zeptoUrl, HttpMethod.POST, request, ZeptoResponse.class);
    }

    private HttpEntity<Object> getObjectHttpEntity(ZeptoRequest zeptoRequest) {
        return new HttpEntity<>(zeptoRequest, getHttpHeaders());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("user-agent", userAgent);
        headers.set("Cookie", "showGetAppBanner=true; maxWeightLimitCart=25000; _gid=GA1.2.2101496341.1682018315; latitude=12.9715987; longitude=77.5945627; store_id=b1403534-cd6b-49d0-a7cd-ce20e6497768; cityName=Bengaluru; _ga_37QQVCR1ZS=GS1.1.1682078795.4.0.1682078795.0.0.0; _gat=1; _ga=GA1.2.701660210.1682018314; _gat_gtag_UA_240822873_1=1; _ga_52LKG2B3L1=GS1.1.1682078795.4.1.1682078810.0.0.0");
        headers.set("storeId", " b1403534-cd6b-49d0-a7cd-ce20e6497768");
        return headers;
    }
}
