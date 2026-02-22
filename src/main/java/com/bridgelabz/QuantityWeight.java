package com.bridgelabz;

import java.util.Objects;

/**
 * UC9 - QuantityWeight Class
 * Immutable Value Object
 */
public final class QuantityWeight {

    private static final double EPSILON = 1e-6;

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // ========================
    // Equality
    // ========================
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() / EPSILON));
    }

    // ========================
    // Conversion
    // ========================
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = this.toBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityWeight(converted, targetUnit);
    }

    // ========================
    // Addition (Implicit Unit)
    // ========================
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    // ========================
    // Addition (Explicit Unit)
    // ========================
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumInBase =
                this.toBaseUnit() + other.toBaseUnit();

        double converted =
                targetUnit.convertFromBaseUnit(sumInBase);

        return new QuantityWeight(converted, targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}