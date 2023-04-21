package com.grocery.diff.controller;

import com.grocery.diff.service.BigbasketService;
import com.grocery.diff.service.BlinkItService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bb")
@RequiredArgsConstructor
public class BigBasketController {

    private final BigbasketService bigbasketService;

    @GetMapping(path = "/search")
    private void getProduct(@RequestParam String query) {
        bigbasketService.getProduct(query);
    }

}
