package com.bridgelabz;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void main(String[] args) {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Input: " + feet + " and " + inches);
        System.out.println("Output: Equal (" + feet.equals(inches) + ")");

        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Input: " + inch1 + " and " + inch2);
        System.out.println("Output: Equal (" + inch1.equals(inch2) + ")");
    }
}