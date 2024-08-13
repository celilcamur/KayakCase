package com.kayak.core.configuration;

import com.kayak.Application;
import cucumber.runtime.java.picocontainer.PicoFactory;

public class CustomPicoFactory extends PicoFactory {

    public CustomPicoFactory() {
        Application.initialize();
    }
}