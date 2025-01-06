package com.stocks.Stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class KeyExecutives {

    @JsonProperty("name")
    private String name;
    @JsonProperty("salary")
    private String salary;
    @JsonProperty("function")
    private String function;
    @JsonProperty("exercised")
    private String exercised;
    @JsonProperty("birth_year")
    private String birthYear;

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof KeyExecutives)){
            return false;
        }

        KeyExecutives that = (KeyExecutives) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
