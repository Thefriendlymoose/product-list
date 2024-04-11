package com.ellos.backendtest.model.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    @JsonProperty("skusData")
    private List<SkuData> skusData;
    @JsonProperty("currentPrice")
    private double currentPrice;
    @JsonProperty("originalPrice")
    private double originalPrice;
    @JsonProperty("name")
    private String name;


    public List<SkuData> getSkusData() {
        return skusData;
    }

    public void setSkusData(List<SkuData> skusData) {
        this.skusData = skusData;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
