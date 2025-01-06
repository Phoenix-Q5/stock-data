package com.stocks.Stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Data
public class Ticker {

    @JsonProperty("name")
    private String name;
    @JsonProperty("ticker")
    private String ticker;
    @JsonProperty("item_type")
    private String itemType;
    @JsonProperty("sector")
    private String sector;
    @JsonProperty("industry")
    private String industry;
    @JsonProperty("exchange_code")
    private String exchangeCode;
    @JsonProperty("full_time_employees")
    private Integer fullTimeEmployees;
    @JsonProperty("ipo_date")
    private String ipoDate;
    @JsonProperty("date_founded")
    private String dateFounded;

    @JsonProperty("key_executives")
    private List<KeyExecutives> keyExecutives;
    @JsonProperty("address")
    private Address address;

    @JsonProperty("post_address")
    private Address postAddress;
    @JsonProperty("incorporation")
    private String incorporation;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("about")
    private String about;

    @JsonProperty("stock_exchanges")
    private List<StockExchanges> stockExchanges;

    @Override
    public int hashCode(){
        return Objects.hash(name, ticker);
    }
}
