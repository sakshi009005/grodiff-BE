package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class VariantInfo {

    private String mrp;
    private String unit;
    private String inventory;
    private String name;
    @JsonProperty(value = "image_url")
    private String imageUrl;
}
