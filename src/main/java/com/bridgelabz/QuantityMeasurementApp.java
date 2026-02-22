package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        System.out.println("=== UC9 Weight Demonstration ===");

        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight gram = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight pound = new QuantityWeight(2.20462, WeightUnit.POUND);

        // Equality
        System.out.println(kg.equals(gram));     // true
        System.out.println(kg.equals(pound));    // true

        // Conversion
        System.out.println(kg.convertTo(WeightUnit.GRAM));
        System.out.println(gram.convertTo(WeightUnit.KILOGRAM));
        System.out.println(kg.convertTo(WeightUnit.POUND));

        // Addition
        System.out.println(kg.add(gram)); // default kg
        System.out.println(kg.add(gram, WeightUnit.GRAM));
        System.out.println(pound.add(kg, WeightUnit.POUND));
    }
}