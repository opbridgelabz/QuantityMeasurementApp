package com.bridgelabz;

import java.util.Objects;

/**
 * UC3 - Generic Length class implementing DRY principle.
 */
public class Length {

    private final double value;
    private final LengthUnit unit;

    /**
     * Enum representing supported length units.
     * Conversion factor defined relative to FEET.
     */
    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0);   // 1 inch = 1/12 feet

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    /**
     * Convert this length to base unit (FEET).
     */
    private double convertToBaseUnit() {
        return unit.toFeet(value);
    }

    /**
     * Compare two Length objects.
     */
    public boolean compare(Length other) {
        if (other == null) {
            return false;
        }
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
