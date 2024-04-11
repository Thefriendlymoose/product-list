package com.ellos.backendtest.utils;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.net.URI;

public class HttpRequestUtil {

    public static <T> T getReqeust(URI uri, ParameterizedTypeReference<T> responseType) {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(responseType);
    }
}
