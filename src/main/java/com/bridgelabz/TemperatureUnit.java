package com.bridgelabz;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT,
    KELVIN;

    // Temperature does NOT support arithmetic
    @Override
    public boolean supportsArithmetic() {
        return false;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public double convertToBaseUnit(double value) {
        switch (this) {
            case CELSIUS:
                return value;
            case FAHRENHEIT:
                return (value - 32) * 5 / 9;
            case KELVIN:
                return value - 273.15;
            default:
                throw new IllegalArgumentException("Unknown unit");
        }
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        switch (this) {
            case CELSIUS:
                return baseValue;
            case FAHRENHEIT:
                return (baseValue * 9 / 5) + 32;
            case KELVIN:
                return baseValue + 273.15;
            default:
                throw new IllegalArgumentException("Unknown unit");
        }
    }

	@Override
	public double getConversionFactor() {
		// TODO Auto-generated method stub
		return 0;
	}
}