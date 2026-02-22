package com.bridgelabz;

public class QuantityMeasurementApp {

    // UC1–UC4: Equality Demonstration
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // UC5: Conversion Demonstration
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit from,
            Length.LengthUnit to) {

        double convertedValue = Length.convert(value, from, to);
        return new Length(convertedValue, to);
    }

    // UC6: Addition (Result in First Operand Unit)
    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    // UC7: Addition (Explicit Target Unit)
    public static Length demonstrateLengthAddition(
            Length l1,
            Length l2,
            Length.LengthUnit targetUnit) {

        return l1.add(l2, targetUnit);
    }

    // ✅ Main method for manual execution (console testing)
    public static void main(String[] args) {

        System.out.println("=== Quantity Measurement Application (UC1 → UC7) ===");

        Length oneFoot = new Length(1.0, Length.LengthUnit.FEET);
        Length twelveInches = new Length(12.0, Length.LengthUnit.INCHES);

        // Equality
        System.out.println("\nEquality Check:");
        System.out.println("1 Foot == 12 Inches ? " +
                demonstrateLengthEquality(oneFoot, twelveInches));

        // Conversion
        System.out.println("\nConversion:");
        Length converted = demonstrateLengthConversion(
                1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);
        System.out.println("1 Foot in Inches = " + converted);

        // UC6 Addition (default unit)
        System.out.println("\nAddition (Default Unit - UC6):");
        Length sumDefault = demonstrateLengthAddition(oneFoot, twelveInches);
        System.out.println("1 Foot + 12 Inches = " + sumDefault);

        // UC7 Addition (explicit target unit)
        System.out.println("\nAddition (Explicit Target Unit - UC7):");

        Length sumInInches = demonstrateLengthAddition(
                oneFoot,
                twelveInches,
                Length.LengthUnit.INCHES);

        System.out.println("1 Foot + 12 Inches in INCHES = " + sumInInches);

        Length sumInYards = demonstrateLengthAddition(
                oneFoot,
                twelveInches,
                Length.LengthUnit.YARDS);

        System.out.println("1 Foot + 12 Inches in YARDS = " + sumInYards);

        System.out.println("\n=== Execution Completed ===");
    }
}