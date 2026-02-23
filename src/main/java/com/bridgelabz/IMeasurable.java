package com.bridgelabz;

@FunctionalInterface
interface SupportsArithmetic {
    boolean isSupported();
}

public interface IMeasurable {

    // Default: all measurable units support arithmetic
    SupportsArithmetic supportsArithmetic = () -> true;

    // Mandatory conversion methods
    String getUnitName();
    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);

    default boolean supportsArithmetic() {
        return true; // default: allowed
    }

    default void validateOperationSupport(String operation) {
        if (!supportsArithmetic()) {
            throw new UnsupportedOperationException(
                    getUnitName() + " does not support " + operation + " operation."
            );
        }
    }
}