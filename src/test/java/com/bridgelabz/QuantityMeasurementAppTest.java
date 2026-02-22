package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(inches.equals(feet));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testEquality_NullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void testEquality_InvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(1.0, null));
    }
    
    @Test
    public void testEquality_YardToYard_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void testEquality_CentimeterToInch_EquivalentValue() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void testEquality_CentimeterToFeet_NotEqual() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(cm.equals(feet));
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
    
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
    void testConversion_RoundTrip() {
        double v = 5.0;
        double converted = Length.convert(v,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        double back = Length.convert(converted,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(v, back, 1e-6);
    }

    @Test
    void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class,
            () -> Length.convert(1.0,
                null,
                Length.LengthUnit.INCHES));
    }
}