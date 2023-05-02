package com.grocery.diff.controller;

import com.grocery.diff.model.BlinkItResponse;
import com.grocery.diff.service.BlinkItService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/blink-it")
@RequiredArgsConstructor
public class BlinkItController {

    private final BlinkItService blinkItService;

    @GetMapping(path = "/search")
    @CrossOrigin(origins = "*")
    public ResponseEntity<BlinkItResponse> getProduct(@RequestParam String query, @RequestParam(name = "lon") String longitude, @RequestParam(name = "lat") String latitude) {
        try {
            return ResponseEntity.ok(blinkItService.getProduct(query, longitude, latitude).getBody());
        } catch (Exception e) {
            BlinkItResponse blinkItResponse = new BlinkItResponse();
            blinkItResponse.setErrorMsg(e.getMessage());
            return ResponseEntity.internalServerError().body(blinkItResponse);
        }
    }
}
