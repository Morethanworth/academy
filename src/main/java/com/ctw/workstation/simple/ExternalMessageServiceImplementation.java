package com.ctw.workstation.simple;

import io.quarkus.logging.Log;


public class ExternalMessageServiceImplementation implements ExternalMessageService {

    @Override
    public String sayHelloFromOuterSpace(String name) {
        return "Hello form outer space " + name;
    }

    @Override
    public String sayHelloFromOuterSpace() {
        Log.info("Hello form outer space");
        return "Hello form outer space";
    }

}
