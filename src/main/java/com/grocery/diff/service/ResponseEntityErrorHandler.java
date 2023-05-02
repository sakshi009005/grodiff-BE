package com.grocery.diff.service;

import com.grocery.diff.exception.ProductNotFetchedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.List;

@Component
public class ResponseEntityErrorHandler implements ResponseErrorHandler {

    private List<HttpMessageConverter<?>> messageConverters;

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return hasError(response.getStatusCode());
    }

    protected boolean hasError(HttpStatus statusCode) {
        return (statusCode.is4xxClientError() || statusCode.is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse response) {
        throw new ProductNotFetchedException();
    }
}