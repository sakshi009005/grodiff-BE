package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlinkItProduct {

    private String price;
    @JsonProperty(value = "unit")
    private String weight;
    @JsonProperty(value = "inventory")
    private String availableQuantity;
    private String name;
    @JsonProperty(value = "image_url")
    private String imageUrl;
    @JsonProperty(value = "product_id")
    private Integer productId;
    @JsonProperty(value = "variant_info")
    private List<BlinkItProduct> variants;

   /* @JsonProperty(value = "variant_info")
    private void mapVariantInfo(List<Map<String, Object>> variants) {
        List<BlinkItProduct> variantInfo = new ArrayList<>();
        variants.forEach(variant -> {
            if (Objects.nonNull(variant.get("product_id")) &&
                    variant.get("product_id") != this.productId) {
                variantInfo.add((new ObjectMapper().convertValue(variant, BlinkItProduct.class)));
            }
        });
        this.variantInfo = variantInfo;
    }*/
}
