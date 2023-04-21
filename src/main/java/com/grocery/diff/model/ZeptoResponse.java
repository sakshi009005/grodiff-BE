package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZeptoResponse {

    List<ZeptoProduct> zeptoProducts;

    @JsonProperty("layout")
    private void mapJsonObject(List<Map<String, Object>> layOuts) {
        List<ZeptoProduct> products = new ArrayList<>();
        if (!CollectionUtils.isEmpty(layOuts)) {
            layOuts.forEach(layOut -> {
                mapLayOut(products, layOut);
            });
            this.zeptoProducts = products;
        }
    }

    private void mapLayOut(List<ZeptoProduct> products, Map<String, Object> layOut) {
        if (!layOut.get("widgetId").equals("AUTO_SUGGEST")) {
            getItems(layOut).forEach(item ->
                    products.add(new ObjectMapper().convertValue(item.get("productResponse"), ZeptoProduct.class))
            );

        }
    }

    private List<Map<String, Object>> getItems(Map<String, Object> layOut) {
        Map<String, Object> data = (Map<String, Object>) layOut.get("data");
        Map<String, Object> resolver = (Map<String, Object>) data.get("resolver");
        Map<String, Object> resolverData = (Map<String, Object>) resolver.get("data");
        return (List<Map<String, Object>>) resolverData.get("items");
    }
}
