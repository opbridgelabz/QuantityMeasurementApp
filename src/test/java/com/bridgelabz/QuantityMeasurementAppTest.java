package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void lengthFeetEqualsInches() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    void weightKilogramEqualsGrams() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(grams));
    }

    @Test
    void convertFeetToInches() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue());
    }

    @Test
    void addLengthUnits() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches, LengthUnit.FEET);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void crossCategoryComparisonShouldFail() {
        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    void constructorShouldRejectNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void constructorShouldRejectInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }
    
    @Test
    void testEquality_LitreToMillilitre() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    @Test
    void testEquality_LitreToGallon() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        assertTrue(litre.equals(gallon));
    }

    @Test
    void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, result.getValue());
    }

    @Test
    void testAddition_LitrePlusMillilitre() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void testAddition_GallonPlusLitre_ExplicitTarget() {
        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                gallon.add(litre, VolumeUnit.GALLON);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void testVolumeVsLength_Incompatible() {
        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertFalse(volume.equals(length));
    }
}