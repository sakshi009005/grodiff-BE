package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class BlinkItResponse extends ErrorResponse{

    private List<BlinkItProduct> products;

}
