package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BigBasketProduct {
    private String sp;
    private String w;
    private String p_img_url;
    private String p_desc;
    @JsonProperty(value = "all_prods")
    private BigBasketProduct[] variants;
}
