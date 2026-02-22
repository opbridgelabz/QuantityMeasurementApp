package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);

        System.out.println(yard + " equals " + feet + " ? " + yard.equals(feet));

        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);

        System.out.println(cm + " equals " + inches + " ? " + cm.equals(inches));
    }
}