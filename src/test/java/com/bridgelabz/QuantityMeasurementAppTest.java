package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // ================= UC12 BEHAVIOR PRESERVATION =================

    @Test
    void testAdd_UC12_BehaviorPreserved() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.add(inches);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testSubtract_UC12_BehaviorPreserved() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(9.5, result.getValue());
    }

    @Test
    void testDivide_UC12_BehaviorPreserved() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(5.0, q1.divide(q2));
    }

    // ================= VALIDATION CONSISTENCY =================

    @Test
    void testValidation_NullOperand_AllOperations() {
        Quantity<LengthUnit> q =
                new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q.add(null));
        assertThrows(IllegalArgumentException.class, () -> q.subtract(null));
        assertThrows(IllegalArgumentException.class, () -> q.divide(null));
    }

    @Test
    void testValidation_CrossCategory_AllOperations() {
        Quantity<LengthUnit> length =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(5.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class,
                () -> length.add((Quantity) weight));

        assertThrows(IllegalArgumentException.class,
                () -> length.subtract((Quantity) weight));

        assertThrows(IllegalArgumentException.class,
                () -> length.divide((Quantity) weight));
    }

    // ================= DIVISION BY ZERO =================

    @Test
    void testDivide_ByZero_ThrowsException() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class,
                () -> q1.divide(q2));
    }

    // ================= ROUNDING CHECK =================

    @Test
    void testAdd_Rounding_TwoDecimals() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(1.234, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(0.006, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(1.24, result.getValue());
    }

    @Test
    void testDivide_NoRounding() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertEquals(1.6666666666666667, q1.divide(q2));
    }

    // ================= IMMUTABILITY =================

    @Test
    void testImmutability_AfterAdd() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        q1.add(q2);

        assertEquals(10.0, q1.getValue());
    }

    @Test
    void testImmutability_AfterSubtract() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        q1.subtract(q2);

        assertEquals(10.0, q1.getValue());
    }
}