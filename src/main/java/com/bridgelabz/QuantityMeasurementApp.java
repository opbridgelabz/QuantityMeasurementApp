package com.bridgelabz;

public class QuantityMeasurementApp {

//  System.out.println("commit to show project on profile");


    public static void main(String[] args) {

        demonstrateTemperatureEquality();
        demonstrateTemperatureConversion();
        demonstrateUnsupportedTemperatureAddition();
        demonstrateSubtraction();
    }

    private static void demonstrateTemperatureEquality() {
        System.out.println("---- Temperature Equality ----");

        Quantity<TemperatureUnit> c =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> f =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("0°C equals 32°F ? " + c.equals(f));
        System.out.println();
    }

    private static void demonstrateTemperatureConversion() {
        System.out.println("---- Temperature Conversion ----");

        Quantity<TemperatureUnit> c =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> f =
                c.convertTo(TemperatureUnit.FAHRENHEIT);

        System.out.println("100°C in Fahrenheit = " + f.getValue());
        System.out.println();
    }

    private static void demonstrateUnsupportedTemperatureAddition() {
        System.out.println("---- Unsupported Temperature Addition ----");

        Quantity<TemperatureUnit> c =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        try {
            c.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS));
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println();
    }

    private static void demonstrateSubtraction() {
        System.out.println("---- Length Subtraction ----");

        // Assumes LengthUnit exists and supports arithmetic
        Quantity<LengthUnit> feet1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(4.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = feet1.subtract(feet2);

        System.out.println("10 FEET - 4 FEET = " +
                result.getValue() + " " + result.getUnit());
    }
}
