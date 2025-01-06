package com.stocks.Stock.service;

import com.stocks.Stock.config.StockRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Value("${api.baseurl}")
    private String baseUrl;

    @Autowired
    protected StockRestTemplate restTemplate;

    protected final ThreadLocal<ResponseEntity<?>> response = new ThreadLocal<>();

    public  <T>ResponseEntity<T> getForEntity(String basePath, String uri, Class<T> responseType, Object... uriVariables){
        restTemplate.withBasePath(baseUrl + basePath);
        ResponseEntity<T> response = restTemplate.getForEntity(uri, responseType, uriVariables);
        this.response.set(response);
        return  response;
    }

    public  <T>ResponseEntity<T> getForEntity(String basePath,String uri, ParameterizedTypeReference<T> responseType, Object... uriVariables){
        restTemplate.withBasePath(baseUrl + basePath);
        ResponseEntity<T> response = restTemplate.exchange(uri, responseType, uriVariables);
        this.response.set(response);
        return  response;
    }

}
