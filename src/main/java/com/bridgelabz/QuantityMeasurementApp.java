package com.bridgelabz;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {
        return q1.equals(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> quantity, U targetUnit) {
        return quantity.convertTo(targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {
        return q1.add(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {

        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length equal? " +
                demonstrateEquality(length1, length2));

        System.out.println("1 foot in inches: " +
                demonstrateConversion(length1, LengthUnit.INCHES));

        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight equal? " +
                demonstrateEquality(weight1, weight2));

        System.out.println("1 kg in grams: " +
                demonstrateConversion(weight1, WeightUnit.GRAM));
        
     // Volume Demonstration

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> volume3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        System.out.println("Volume equality (L vs mL): "
                + demonstrateEquality(volume1, volume2));

        System.out.println("1 L in Gallon: "
                + demonstrateConversion(volume1, VolumeUnit.GALLON));

        System.out.println("Add 1L + 1000mL: "
                + demonstrateAddition(volume1, volume2));

        System.out.println("Add 1Gallon + 1L in Gallon: "
                + demonstrateAddition(volume3, volume1, VolumeUnit.GALLON));
    }
}