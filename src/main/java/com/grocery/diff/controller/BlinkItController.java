package com.grocery.diff.controller;

import com.grocery.diff.service.BlinkItService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/blinkit")
@RequiredArgsConstructor
public class BlinkItController {

    private final BlinkItService blinkItService;

    @GetMapping(path = "/search")
    private void getProduct(String productName, Double longitude, Double latitude) {
        blinkItService.getProduct();
    }

}
