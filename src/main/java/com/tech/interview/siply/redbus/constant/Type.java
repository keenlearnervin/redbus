package com.tech.interview.siply.redbus.constant;

public enum Type {
    REGULAR("regular"),
    PREMIUM("premium");

    String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
