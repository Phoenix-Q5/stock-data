package com.stocks.Stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TickerList {
    @JsonProperty("ticker")
    private String ticker;
}
