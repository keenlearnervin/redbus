package com.tech.interview.siply.redbus.constant;

public enum FuelType {
    PETROL("petrol"),
    DIESEL("diesel"),
    ELECTRIC("electric"),
    HYBRID("hybrid"),
    CNG("cng"),
    LPG("lpg");

    String fuelValue;

    FuelType(String fuelType) {
        this.fuelValue = fuelType;
    }

    private String getFuelType() {
        return this.fuelValue;
    }
}
