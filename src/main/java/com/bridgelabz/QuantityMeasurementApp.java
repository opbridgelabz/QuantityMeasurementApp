package com.bridgelabz;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean
    demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
        return q1.equals(q2);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateConversion(Quantity<U> q, U targetUnit) {
        return q.convertTo(targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(Quantity<U> q1, Quantity<U> q2) {
        return q1.add(q2);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }

    // ========== UC12 METHODS ==========

    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2) {
        return q1.subtract(q2);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.subtract(q2, targetUnit);
    }

    public static <U extends IMeasurable> double
    demonstrateDivision(Quantity<U> q1, Quantity<U> q2) {
        return q1.divide(q2);
    }

    // ========== MAIN ==========

    public static void main(String[] args) {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Subtraction: "
                + demonstrateSubtraction(feet, inches));

        System.out.println("Subtraction (target inches): "
                + demonstrateSubtraction(feet, inches, LengthUnit.INCHES));

        System.out.println("Division: "
                + demonstrateDivision(feet, new Quantity<>(2.0, LengthUnit.FEET)));

        Quantity<VolumeUnit> litre =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Subtraction: "
                + demonstrateSubtraction(litre, ml));

        System.out.println("Volume Division: "
                + demonstrateDivision(litre, new Quantity<>(2.0, VolumeUnit.LITRE)));
    }
}