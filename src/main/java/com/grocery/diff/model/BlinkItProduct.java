package com.grocery.diff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class BlinkItProduct {
    @JsonProperty(value="variant_info")
    private VariantInfo[] variantInfo;

}
