package com.kayak;

import com.kayak.utils.converters.UnirestObjectMapper;
import com.mashape.unirest.http.Unirest;

public class Application {

    public static void initialize() {
        Unirest.setObjectMapper(new UnirestObjectMapper());
    }

}
