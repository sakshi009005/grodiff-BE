package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties
@Data
public class BigBasketResponse {

    private List<BigBasketProduct> bigBasketProduct;

    @JsonProperty("json_data")
    private void mapJsonObject(Map<String, Object> jsonData) {
        List<BigBasketProduct> products = new ArrayList<>();
        if(Objects.nonNull(jsonData)) {
            List parentObject = (List) jsonData.get("tab_info");
            if (!CollectionUtils.isEmpty(parentObject)) {
                mapProduct(products, parentObject);
            }
        }
        this.bigBasketProduct = products;
    }

    private void mapProduct(List<BigBasketProduct> products, List parentObject) {
        Map<String, List> productInfo = (((Map<String, Map<String, List>>) (parentObject.get(0))).get("product_info"));
        if (Objects.nonNull(productInfo)) {
            productInfo.get("products").forEach(x ->
                    products.add(new ObjectMapper().convertValue(x, BigBasketProduct.class))
            );
        }
    }
}
