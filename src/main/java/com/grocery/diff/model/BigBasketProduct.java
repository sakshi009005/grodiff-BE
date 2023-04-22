package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BigBasketProduct {
    @JsonProperty(value = "sp")
    private String price;
    @JsonProperty(value = "w")
    private String weight;
    @JsonProperty(value = "p_img_url")
    private String imageUrl;
    @JsonProperty(value = "p_desc")
    private String name;
    @JsonProperty(value = "sku")
    private Integer productId;
    @JsonProperty(value = "all_prods")
    private BigBasketProduct[] variants;
}
