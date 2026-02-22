package com.bridgelabz;

import java.util.Objects;

/**
 * UC4 - Extended Unit Support (Feet, Inches, Yards, Centimeters)
 */
public class Length {

    private final double value;
    private final LengthUnit unit;

    /**
     * All units convert to INCHES (base unit)
     */
    public enum LengthUnit {

        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double toInchesFactor;

        LengthUnit(double toInchesFactor) {
            this.toInchesFactor = toInchesFactor;
        }

        public double toBase(double value) {
            return value * toInchesFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return unit.toBase(value);
    }

    public boolean compare(Length other) {
        if (other == null) return false;

        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Length other = (Length) o;
        return compare(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}