package com.stocks.Stock.controller;

import com.stocks.Stock.model.ResponseWrapper;

import com.stocks.Stock.model.Ticker;
import com.stocks.Stock.model.TickerList;
import com.stocks.Stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StocksController {
    private final String TICKER_BASE = "/tickerinfo";
    private final String TICKER_LIST = "/tickerslist";
    private final String TICKER_INFO = "&ticker={ticker}";

    @Autowired
    private StockService stockService;

    @GetMapping("/ticker/{ticker}")
    public Ticker getResultsForTicker(@PathVariable("ticker") String tickerName) {
        ParameterizedTypeReference<ResponseWrapper<Ticker>> typeReference = new ParameterizedTypeReference<>(){};
        ResponseEntity<ResponseWrapper<Ticker>>  response = stockService.getForEntity(TICKER_BASE, TICKER_INFO, typeReference, tickerName);
        return response.getBody().getData();
    }

    @GetMapping("/listTicker")
    public List<TickerList> getTickerList(){
        ParameterizedTypeReference<ResponseWrapper<List<TickerList>>> typeReference = new ParameterizedTypeReference<>(){};
        ResponseEntity<ResponseWrapper<List<TickerList>>> response = stockService.getForEntity(TICKER_LIST, null, typeReference, List.of());
        return response.getBody().getData();
    }

}
