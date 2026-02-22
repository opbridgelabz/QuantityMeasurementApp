package com.bridgelabz;

import java.util.Objects;

/**
 * Generic value object representing a length measurement.
 * Base unit for normalization: INCHES.
 */
public final class Length {

    private final double value;
    private final LengthUnit unit;

    // Small epsilon for floating point comparison
    private static final double EPSILON = 1e-6;

    /**
     * Supported length units.
     * Conversion factors are defined relative to INCHES.
     */
    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factorToInches;

        LengthUnit(double factorToInches) {
            this.factorToInches = factorToInches;
        }

        public double getFactor() {
            return factorToInches;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

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

    // Convert to base unit (inches)
    private double toBaseUnit() {
        return value * unit.getFactor();
    }

    /**
     * Instance method conversion (immutability preserved)
     */
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = toBaseUnit();
        double converted = baseValue / targetUnit.getFactor();

        return new Length(converted, targetUnit);
    }

    /**
     * Static conversion API (raw value)
     */
    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        double base = value * source.getFactor();
        return base / target.getFactor();
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
        return String.format("%.4f %s", value, unit);
    }
}