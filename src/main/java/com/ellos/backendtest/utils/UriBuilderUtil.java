package com.ellos.backendtest.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class UriBuilderUtil {
    public static URI buildEllosUri(String host, String path, String queryPath) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(host)
                .path(path)
                .queryParam("path", UriUtils.encode(queryPath, StandardCharsets.UTF_8))
                .build(true);

        return uriComponents.toUri();
    }
}
