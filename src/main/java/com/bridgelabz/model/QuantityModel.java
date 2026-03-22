package com.bridgelabz.model;

public class QuantityModel {
    private double value;
    private String unit;
    private String type;

    public QuantityModel(double value, String unit, String type) {
        this.value = value;
        this.unit = unit;
        this.type = type;
    }

    public double getValue() { return value; }
    public String getUnit() { return unit; }
    public String getType() { return type; }
    
    @Override
    public String toString()
    {
    	return value+" "+unit+" "+type;
    }
    
    
    
}