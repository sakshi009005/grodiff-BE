package com.grocery.diff.exception;

public class ProductNotFetchedException extends  RuntimeException{

    public ProductNotFetchedException(){
        super("Failed to fetch products");
    }
}
