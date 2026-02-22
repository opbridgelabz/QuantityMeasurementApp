package com.bridgelabz;

import java.util.Objects;

public final class Length {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor; 

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    public Length(double value, LengthUnit unit) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert this object to base unit (inches)
    private double toBaseUnit() {
        return value * unit.getFactor();
    }

    // UC5: static conversion utility
    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double base = value * source.getFactor();
        return base / target.getFactor();
    }

    // UC6: addition result in first operand unit
    public Length add(Length other) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = sumBase / this.unit.getFactor();

        return new Length(result, this.unit);
    }

    // UC7: addition with explicit target unit
    public Length add(Length other, LengthUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = sumBase / targetUnit.getFactor();

        return new Length(result, targetUnit);
    }

    private boolean compare(Length other) {
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        return compare((Length) obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() / EPSILON));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}