package com.grocery.diff.controller;

import com.grocery.diff.model.BlinkItResponse;
import com.grocery.diff.service.BlinkItService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/blink-it")
@RequiredArgsConstructor
public class BlinkItController {

    private final BlinkItService blinkItService;

    @GetMapping(path = "/search")
    private ResponseEntity<BlinkItResponse> getProduct(@RequestParam String query,
                                                       @RequestParam(name = "lon") String longitude,
                                                       @RequestParam(name = "lat") String latitude) {
        return blinkItService.getProduct(query, longitude, latitude);
    }

}
