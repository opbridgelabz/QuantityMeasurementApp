package com.bridgelabz;

import org.junit.jupiter.api.Test;
import com.bridgelabz.QuantityMeasurementApp.Feet;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        assertTrue(first.equals(second), "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(2.0);

        assertFalse(first.equals(second), "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet first = new Feet(1.0);

        assertFalse(first.equals(null), "Feet object should not be equal to null");
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet first = new Feet(1.0);
        String notFeet = "1.0";

        assertFalse(first.equals(notFeet), "Feet object should not be equal to different class");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet first = new Feet(1.0);

        assertTrue(first.equals(first), "Same reference must return true");
    }
}
