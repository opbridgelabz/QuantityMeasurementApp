package com.bridgelabz;
/**
 * UC1: Feet Measurement Equality
 * Responsible for checking equality of two numerical values measured in feet.
 */
public class QuantityMeasurementApp {

    /**
     * Inner class representing a Feet measurement.
     * Immutable and encapsulated.
     */
    public static class Feet {

        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        /**
         * Override equals method to compare Feet objects
         */
        @Override
        public boolean equals(Object obj) {

            // Reference check
            if (this == obj) {
                return true;
            }

            // Null check
            if (obj == null) {
                return false;
            }

            // Type check
            if (getClass() != obj.getClass()) {
                return false;
            }

            // Safe casting
            Feet other = (Feet) obj;

            // Compare double values safely
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method to demonstrate equality
    public static void main(String[] args) {

        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        boolean result = first.equals(second);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }
}