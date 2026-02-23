package com.bridgelabz;

import java.util.Objects;

public class Quantity<T extends IMeasurable> {

    private final double value;
    private final T unit;

    public Quantity(double value, T unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public T getUnit() {
        return unit;
    }

    // Convert to another unit
    public Quantity<T> convertTo(T targetUnit) {
        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    // Addition
    public Quantity<T> add(Quantity<T> other) {
        unit.validateOperationSupport("addition");

        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        return new Quantity<>(
                unit.convertFromBaseUnit(resultBase),
                unit
        );
    }

    // Subtraction
    public Quantity<T> subtract(Quantity<T> other) {
        unit.validateOperationSupport("subtraction");

        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 - base2;

        return new Quantity<>(
                unit.convertFromBaseUnit(resultBase),
                unit
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        // Cross-category check
        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.convertToBaseUnit(value));
    }
}