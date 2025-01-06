package com.stocks.Stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {

    @JsonProperty("city")
    private String city;
    @JsonProperty("street1")
    private String street1;
    @JsonProperty("street2")
    private String street2;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("stateOrCountry")
    private String stateOrCountry;


}
