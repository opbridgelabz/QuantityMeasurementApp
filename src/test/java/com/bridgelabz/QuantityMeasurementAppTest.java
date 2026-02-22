package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testConvert_FeetToInches() {
        Length l = new Length(1.0, LengthUnit.FEET);
        assertEquals(new Length(12.0, LengthUnit.INCHES),
                l.convertTo(LengthUnit.INCHES));
    }

    @Test
    void testAdd_FeetAndInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.FEET);
        assertEquals(new Length(2.0, LengthUnit.FEET), result);
    }

    @Test
    void testYardToFeet() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }

    @Test
    void testCentimeterToFeet() {
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);
        assertTrue(cm.equals(feet));
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(1.0, null));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(Double.NaN, LengthUnit.FEET));
    }
}