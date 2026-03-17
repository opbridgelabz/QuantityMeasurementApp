package com.bridgelabz.model;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private QuantityModel q1;
    private QuantityModel q2;
    private String operation;
    private double result;
    private String error;

    public QuantityMeasurementEntity(QuantityModel q1, QuantityModel q2, String operation, double result) {
        this.q1 = q1;
        this.q2 = q2;
        this.operation = operation;
        this.result = result;
    }

    public QuantityMeasurementEntity(String error) {
        this.error = error;
    }
}