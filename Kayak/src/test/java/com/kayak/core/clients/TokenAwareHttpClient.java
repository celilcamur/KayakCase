package com.kayak.core.clients;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;

import com.mashape.unirest.request.body.RequestBodyEntity;
import org.apache.log4j.Logger;


public abstract class TokenAwareHttpClient {
    private static final Logger LOGGER = Logger.getLogger(TokenAwareHttpClient.class);
    private String baseUrl = "https://reqres.in/api";

    public TokenAwareHttpClient() {

    }

    protected GetRequest get(String path) {
        return Unirest
                .get(String.join("/", baseUrl, path));
    }

    protected RequestBodyEntity post(String path, Object body) {
        return Unirest
                .post(String.join("/", baseUrl, path))
                .header("Content-Type", "application/json")
                .body(body);
    }
}
