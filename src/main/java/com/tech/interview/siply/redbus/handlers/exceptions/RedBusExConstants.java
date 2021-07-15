package com.tech.interview.siply.redbus.handlers.exceptions;

public enum RedBusExConstants {
    ERROR_TYPE_KEY("ErrorType");
    String value;

    RedBusExConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
