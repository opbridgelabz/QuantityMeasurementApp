package com.bridgelabz.enums;

public enum WeightUnit {
    KG(1000), GRAM(1);

    private final double baseValue;

    WeightUnit(double baseValue) {
        this.baseValue = baseValue;
    }

    public double toBase(double value) {
        return value * baseValue;
    }
}