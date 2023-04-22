package com.grocery.diff.controller;

import com.grocery.diff.model.BigBasketResponse;
import com.grocery.diff.service.BigbasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/bb")
@RequiredArgsConstructor
public class BigBasketController {

    private final BigbasketService bigbasketService;

    @GetMapping(path = "/search",produces="application/json")
    public ResponseEntity<BigBasketResponse> getProduct(@RequestParam String query) throws IOException {
        return ResponseEntity.ok(bigbasketService.getProduct(query).getBody());
    }

}
