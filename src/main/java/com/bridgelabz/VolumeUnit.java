package com.bridgelabz;

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),              // Base unit
    MILLILITRE(0.001),       // 1 mL = 0.001 L
    GALLON(3.78541);         // 1 gallon = 3.78541 L

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return round(value * conversionFactor);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return round(baseValue / conversionFactor);
    }

    @Override
    public String getUnitName() {
        return name();
    }

    private double round(double value) {
        return Math.round(value * 100000.0) / 100000.0;
    }
}