package com.bridgelabz.enums;

public enum LengthUnit {
    FEET(12), INCH(1);

    private final double baseValue;

    LengthUnit(double baseValue) {
        this.baseValue = baseValue;
    }

    public double toBase(double value) {
        return value * baseValue;
    }
}