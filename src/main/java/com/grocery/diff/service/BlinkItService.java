package com.grocery.diff.service;

import com.grocery.diff.model.BlinkItResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BlinkItService {

    private final RestTemplate restTemplate;
    @Value("${external.user-agent}")
    public String userAgent;
    @Value("${external.api.blink-it}")
    private String blinkItApi;

    public ResponseEntity<BlinkItResponse> getProduct(String query, String longitude, String latitude) {
        HttpEntity<Object> request = getObjectHttpEntity(longitude, latitude);

        return restTemplate.exchange(String.format("%s%s%s", blinkItApi, "?start=0&size=-1&search_type=7&q=", query),
                HttpMethod.GET, request, BlinkItResponse.class);
    }

    private HttpEntity<Object> getObjectHttpEntity(String longitude, String latitude) {
        return new HttpEntity<>(getHttpHeaders(longitude, latitude));
    }

    private HttpHeaders getHttpHeaders(String longitude, String latitude) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("lat", latitude);
        headers.set("lon", longitude);
        headers.set("user-agent", userAgent);
        headers.set("Cookie", "gr_1_deviceId=565e4fea-ba88-4243-9a70-e599e2023358; city=Bangalore; __cfruid=6f067f26ab1066a5fbc52b50bb987d18b6913403-1681995012; _cfuvid=bwlzOg2P6kxDkQPtMFXztvBnukGbHIeorU6ZKnERpfQ-1681995012936-0-604800000; rl_anonymous_id=%22d97ca157-0e10-451b-9578-b0b7a7714a78%22; rl_user_id=%22%22; _gcl_au=1.1.1184462904.1681995130; _ga=GA1.2.1644890953.1681995138; _gid=GA1.2.750035624.1681995138; _fbp=fb.1.1681995138675.1658435388; gr_1_locality=3; gr_1_lat=12.8905808; gr_1_lon=77.6426413; gr_1_landmark=undefined; __cf_bm=0DB0WyxwmdFW_gfw8Dtu.PtOXMuRvkT.OEYrPxq_mls-1682061840-0-ASzk+lb+pXGUxV2HkAVeCd00oaGBb/oj8JqbrZAzdgXxA+RV+5YFTYh+m07vVmyE+5HjEYwcTAUWsVNggkW0Hn4=; rl_trait=%7B%22device_uuid%22%3A%22565e4fea-ba88-4243-9a70-e599e2023358%22%2C%22session_uuid%22%3A%22%22%2C%22install_source%22%3A%22%22%2C%22install_campaign%22%3A%22%22%2C%22phone%22%3Anull%2C%22email%22%3A%22%22%2C%22cart_id%22%3Anull%2C%22rn_bundle_version%22%3A%229.3.12%22%2C%22platform%22%3A%22desktop_web%22%2C%22segment_type%22%3Anull%2C%22monthly_orders%22%3Anull%2C%22city_id%22%3A3%2C%22chain_id%22%3A1383%2C%22longitude%22%3A77.6426413%2C%22user_type%22%3Anull%2C%22lifetime_orders%22%3Anull%2C%22latitude%22%3A12.8905808%2C%22city_name%22%3A%22Bengaluru%22%2C%22merchant_id%22%3A30614%2C%22merchant_name%22%3A%22Super%20Store%20-%20Bengaluru%20Haralur%20ES25%22%7D; _gat_UA-85989319-1=1");
        return headers;
    }
}
