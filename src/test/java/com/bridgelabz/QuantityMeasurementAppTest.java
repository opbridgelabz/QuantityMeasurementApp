package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    // UC1-UC3 Equality

    @Test
    void testFeetEquality() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(1.0, Length.LengthUnit.FEET)
        );
    }

    @Test
    void testFeetInchesEquality() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );
    }

    @Test
    void testYardToFeetEquality() {
        assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );
    }

    @Test
    void testCentimeterToInchEquality() {
        assertEquals(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES)
        );
    }

    // UC5 Conversion

    @Test
    void testConvertFeetToInches() {
        assertEquals(
                12.0,
                Length.convert(1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES),
                EPSILON
        );
    }

    // UC6 Addition

    @Test
    void testAddition_DefaultUnit() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    // UC7 Addition With Target Unit

    @Test
    void testAddition_TargetInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.INCHES);

        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_TargetYards() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.YARDS);

        assertEquals(0.666666, result.getValue(), EPSILON);
    }
}