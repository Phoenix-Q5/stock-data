package com.stocks.Stock.model;

public class ResponseWrapper<T> {
    private T data;

    public T getData(){
        return this.data;
    }
}
