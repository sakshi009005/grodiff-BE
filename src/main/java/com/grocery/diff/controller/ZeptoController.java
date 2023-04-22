package com.grocery.diff.controller;

import com.grocery.diff.model.ZeptoRequest;
import com.grocery.diff.model.ZeptoResponse;
import com.grocery.diff.service.ZeptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/zepto")
@RequiredArgsConstructor
public class ZeptoController {

    private final ZeptoService zeptoService;

    @GetMapping(path = "/search")
    public ResponseEntity<ZeptoResponse> getProduct(@RequestBody ZeptoRequest zeptoRequest) {
        return zeptoService.getProduct(zeptoRequest);
    }
}
