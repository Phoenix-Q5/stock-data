package com.stocks.Stock.config;

import jakarta.annotation.Nullable;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@NoArgsConstructor
public class RetryableApiClient {

    @Autowired
    private RetryTemplate retryTemplate;

    @Autowired
    private RestTemplate retryRestTemplate;

    protected final <T>ResponseEntity<T> retryableExchange(String url, HttpMethod method, @Nullable HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables){
        return retryTemplate.execute(
                ctx -> retryRestTemplate.exchange(url, method, requestEntity, responseType, uriVariables));
    }

    protected final <T>ResponseEntity<T> retryableExchange(String url, HttpMethod method, @Nullable HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables){
        return retryTemplate.execute(
                ctx -> retryRestTemplate.exchange(url, method, requestEntity, responseType, uriVariables));
    }
}
