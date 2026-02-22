package com.bridgelabz;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;

    public Length(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public Length convertTo(LengthUnit targetUnit) {
        double baseValue = unit.convertToBaseUnit(this.value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);
        return new Length(round(converted), targetUnit);
    }

    public Length add(Length other) {
        return add(other, this.unit);
    }

    public Length add(Length other, LengthUnit targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;
        double finalValue = targetUnit.convertFromBaseUnit(sumBase);

        return new Length(round(finalValue), targetUnit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {
        double base = unit.convertToBaseUnit(value);
        return Objects.hash(base);
    }

    @Override
    public String toString() {
        return "Length{" + value + " " + unit + "}";
    }
}