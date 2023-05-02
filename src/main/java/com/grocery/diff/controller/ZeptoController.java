package com.grocery.diff.controller;

import com.grocery.diff.model.ZeptoRequest;
import com.grocery.diff.model.ZeptoResponse;
import com.grocery.diff.service.ZeptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/zepto")
@RequiredArgsConstructor
public class ZeptoController {

    private final ZeptoService zeptoService;


    @PostMapping(path = "/search")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ZeptoResponse> getProduct(@RequestBody ZeptoRequest zeptoRequest) {
        try {
            return ResponseEntity.ok(zeptoService.getProduct(zeptoRequest).getBody());
        } catch (Exception e) {
            ZeptoResponse zeptoResponse = new ZeptoResponse();
            zeptoResponse.setErrorMsg(e.getMessage());
            return ResponseEntity.internalServerError().body(zeptoResponse);
        }
    }
}
