package com.grocery.diff.controller;

import com.grocery.diff.exception.ProductNotFetchedException;
import com.grocery.diff.model.BigBasketResponse;
import com.grocery.diff.service.BigbasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/bb")
@RequiredArgsConstructor
public class BigBasketController {

    private final BigbasketService bigbasketService;


    @GetMapping(path = "/search", produces = "application/json")
    @CrossOrigin(origins = "*")
    public ResponseEntity<BigBasketResponse> getProduct(@RequestParam String query) {
        try {
            return ResponseEntity.ok(bigbasketService.getProduct(query).getBody());
        }catch (Exception e){
            BigBasketResponse bigBasketResponse= new BigBasketResponse();
            bigBasketResponse.setErrorMsg(e.getMessage());
            return ResponseEntity.internalServerError().body(bigBasketResponse);
        }

    }

}
