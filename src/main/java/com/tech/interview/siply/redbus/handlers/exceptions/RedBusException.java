package com.tech.interview.siply.redbus.handlers.exceptions;

import java.util.HashMap;
import java.util.Map;

public class RedBusException extends Exception {
    private final Map<String, Object> exceptionExtensions = new HashMap<>();

    public RedBusException(String errMsg) {
        super(errMsg);
    }

    public RedBusException withType(RedBusErrTypes redBusErrType) {
        this.exceptionExtensions.put(RedBusExConstants.ERROR_TYPE_KEY.getValue(), redBusErrType);
        return this;
    }
}
