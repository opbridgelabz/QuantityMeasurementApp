package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    /* =========================================================
       UC1 & UC2 – Equality Tests (Feet & Inches)
       ========================================================= */

    @Test
    void testEquality_FeetToFeet_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    void testEquality_DifferentValues_NotEqual() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    void testEquality_NullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    /* =========================================================
       UC4 – Yards & Centimeters Support
       ========================================================= */

    @Test
    void testEquality_YardToFeet() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }

    @Test
    void testEquality_CentimeterToInch() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(inch));
    }

    /* =========================================================
       UC5 – Conversion Tests
       ========================================================= */

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                Length.convert(1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0,
                Length.convert(1.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.INCHES),
                1e-6);
    }

    @Test
    void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> Length.convert(1.0,
                        null,
                        Length.LengthUnit.INCHES));
    }

    /* =========================================================
       UC6 – Addition Tests
       ========================================================= */

    @Test
    void testAddition_SameUnit() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    void testAddition_NullSecondOperand() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> l1.add(null));
    }
}