package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Equality Test:");
        System.out.println(l1 + " equals " + l2 + " ? " + l1.equals(l2));

        System.out.println("\nConversion Test:");
        System.out.println("1 Foot to Inches: " + l1.convertTo(LengthUnit.INCHES));

        System.out.println("\nAddition Test:");
        System.out.println("1 Foot + 12 Inches (Feet): " +
                l1.add(l2, LengthUnit.FEET));

        System.out.println("\nYard Test:");
        Length yard = new Length(1.0, LengthUnit.YARDS);
        System.out.println("1 Yard equals 3 Feet? " +
                yard.equals(new Length(3.0, LengthUnit.FEET)));

        System.out.println("\nCentimeter Test:");
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        System.out.println("30.48 cm equals 1 Foot? " +
                cm.equals(new Length(1.0, LengthUnit.FEET)));

    }
}