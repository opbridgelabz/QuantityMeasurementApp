package com.bridgelabz;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static void main(String[] args) {

        Length result1 = demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        System.out.println(result1); // 2 FEET

        Length result2 = demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );

        System.out.println(result2); // 2 YARDS
    }
}