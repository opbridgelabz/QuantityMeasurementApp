package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    
 // ================= SUBTRACTION TESTS =================

    @Test
    void testSubtraction_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(5.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testSubtraction_CrossUnit() {
        Quantity<LengthUnit> feet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.subtract(inches);

        assertEquals(9.5, result.getValue());
    }

    @Test
    void testSubtraction_ExplicitTargetUnit() {
        Quantity<LengthUnit> feet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.subtract(inches, LengthUnit.INCHES);

        assertEquals(114.0, result.getValue());
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    void testSubtraction_ResultingNegative() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(-5.0, result.getValue());
    }

    @Test
    void testSubtraction_ResultingZero() {
        Quantity<LengthUnit> feet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(120.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.subtract(inches);

        assertEquals(0.0, result.getValue());
    }

    @Test
    void testSubtraction_NullOperand() {
        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> q.subtract(null));
    }

    @Test
    void testSubtraction_CrossCategory() {
        Quantity<LengthUnit> length =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(5.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class,
                () -> length.subtract((Quantity) weight));
    }

    // ================= DIVISION TESTS =================

    @Test
    void testDivision_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result);
    }

    @Test
    void testDivision_CrossUnit() {
        Quantity<LengthUnit> inches =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result = inches.divide(feet);

        assertEquals(1.0, result);
    }

    @Test
    void testDivision_ResultLessThanOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(0.5, result);
    }

    @Test
    void testDivision_ResultEqualOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(1.0, result);
    }

    @Test
    void testDivision_ByZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class,
                () -> q1.divide(q2));
    }

    @Test
    void testDivision_NullOperand() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> q1.divide(null));
    }

    @Test
    void testDivision_CrossCategory() {
        Quantity<LengthUnit> length =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(5.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class,
                () -> length.divide((Quantity) weight));
    }

    // ================= IMMUTABILITY =================

    @Test
    void testSubtraction_Immutability() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

        q1.subtract(q2);

        assertEquals(10.0, q1.getValue());
    }

    @Test
    void testDivision_Immutability() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

        q1.divide(q2);

        assertEquals(10.0, q1.getValue());
    }
}