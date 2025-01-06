package com.stocks.Stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class StockExchanges {

    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("website")
    private String website;
    @JsonProperty("acronym1")
    private String acronym1;
    @JsonProperty("alpha2_code")
    private String alpha2Code;
    @JsonProperty("exchange_mic")
    private String exchangeMic;
    @JsonProperty("exchange_name")
    private String exchangeName;

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(!(o instanceof StockExchanges)){
            return false;
        }

        StockExchanges that = (StockExchanges) o;
        return exchangeName.equals(that.exchangeName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(website, country, exchangeName);
    }
}
