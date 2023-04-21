package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZeptoProduct {

    private String availableQuantity;
    private String sellingPrice;
    private String weight;
    private String imageUrl;
    private String name;

    @JsonProperty("productVariant")
    private void mapProductVariant(Map<String,Object> productVariant){
        if(Objects.nonNull(productVariant)) {
            this.weight = (String) productVariant.get("formattedPacksize");
            List<Map<String, String>> images = (List<Map<String, String>>) productVariant.get("images");
            if(!CollectionUtils.isEmpty(images)) {
                //TODO
                this.imageUrl = "https://cdn.zeptonow.com/production///tr:w-200,ar-1500-1500,pr-true,f-webp,q-80/" +
                        images.get(0).get("path");
            }
        }
    }

    @JsonProperty("product")
    private void mapProductName(Map<String,String> product){
        if(Objects.nonNull(product)) {
            this.name = product.get("name");
        }
    }
}
