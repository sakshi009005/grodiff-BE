package com.grocery.diff.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BigBasketProduct {
    @JsonAlias(value = "sp")
    private String price;
    @JsonAlias(value = "w")
    private String weight;
    @JsonAlias(value = "p_img_url")
    private String imageUrl;
    @JsonAlias(value = "p_desc")
    private String name;
    @JsonAlias(value = "sku")
    private Integer productId;
    @JsonAlias(value = "all_prods")
    private BigBasketProduct[] variants;
}
