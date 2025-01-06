package com.stocks.Stock.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StockRestTemplate extends RetryableApiClient{

    @Value("${api.key}")
    private String accessToken;

    @Getter
    private String basePath;

    public StockRestTemplate withBasePath(String basePath){
        this.basePath = basePath;
        return this;
    }

    public <T>ResponseEntity<T> getForEntity(String uri, Class<T> responseType, Object... uriVariables){
        if(Objects.isNull(uri)){
            uri = "?access_key=" + accessToken;
        }
        else if (!uri.startsWith("/")){
            uri = "?access_key=" + accessToken + uri;
        }
        String url = basePath + uri;
        HttpMethod method = HttpMethod.GET;

        return retryableExchange(url, method, new HttpEntity<>(null), responseType, uriVariables);
    }

    public <T>ResponseEntity<T> exchange(String uri, ParameterizedTypeReference<T> responseType, Object... uriVariables){
        if(Objects.isNull(uri)){
            uri = "?access_key=" + accessToken;
        }
        else if (!uri.startsWith("/")){
            uri = "?access_key=" + accessToken + uri;
        }
        String url = basePath + uri;
        HttpMethod method = HttpMethod.GET;

        return retryableExchange(url, method, new HttpEntity<>(null), responseType, uriVariables);
    }
}
