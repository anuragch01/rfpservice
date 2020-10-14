package com.bettaway.rfp.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Component
public class RequestBuilder {
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    private static URI uriBuilder(String url) {
        URI uri = UriComponentsBuilder.fromUriString(url).build().encode().toUri();
        return uri;
    }

    private static HttpEntity<String> headerAndRequestBuilder(String jsonBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);
        return request;
    }

    public ResponseEntity<String> call(String url, String jsonBody) {
        URI uri = uriBuilder(url);
        HttpEntity<String> request = headerAndRequestBuilder(jsonBody);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        return response;
    }

    public ResponseEntity<String> call(String url, String jsonBody, String authorization) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);
        URI uri = UriComponentsBuilder.fromUriString(url).build().encode().toUri();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        return response;
    }

    public ResponseEntity<String> call(String url, String jsonBody, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);
        URI uri = UriComponentsBuilder.fromUriString(url).build().encode().toUri();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        return response;
    }

}
