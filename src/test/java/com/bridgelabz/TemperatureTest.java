package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void testEquality_CelsiusToFahrenheit() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> f =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertTrue(c.equals(f));
    }

    @Test
    void testConversion() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> f =
                c.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(212.0, f.getValue(), 0.01);
    }

    @Test
    void testUnsupportedAddition() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> c.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS)));
    }

    @Test
    void testCrossCategoryComparison() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<LengthUnit> l =
                new Quantity<>(100.0, LengthUnit.FEET);

        assertFalse(c.equals(l));
    }
}