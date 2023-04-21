package com.grocery.diff.controller;

import com.grocery.diff.model.ZeptoRequest;
import com.grocery.diff.service.ZeptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/zepto")
@RequiredArgsConstructor
public class ZeptoController {

    private  final ZeptoService zeptoService;

    @GetMapping(path = "/search")
    private void getProduct(@RequestBody ZeptoRequest zeptoRequest) {
        zeptoService.getProduct(zeptoRequest);

    }

}
