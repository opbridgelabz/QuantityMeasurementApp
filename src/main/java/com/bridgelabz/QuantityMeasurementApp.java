package com.bridgelabz;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);
        return demonstrateLengthEquality(l1, l2);
    }

    // Overload 1
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit from,
            Length.LengthUnit to) {

        return new Length(value, from).convertTo(to);
    }

    // Overload 2
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

        System.out.println("1 foot → inches = " +
                Length.convert(1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));

        System.out.println("3 yards → feet = " +
                Length.convert(3.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.FEET));

        System.out.println("36 inches → yards = " +
                Length.convert(36.0,
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.YARDS));
    }
}