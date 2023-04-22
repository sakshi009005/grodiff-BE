package com.grocery.diff.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlinkItProduct {

    private String price;

    @JsonAlias(value = "unit")
    private String weight;
    @JsonAlias(value = "inventory")
    private String availableQuantity;
    private String name;
    @JsonAlias(value = "image_url")
    private String imageUrl;
    @JsonAlias(value = "product_id")
    private Integer productId;
    @JsonAlias(value = "variant_info")
    private List<BlinkItProduct> variants;

}
