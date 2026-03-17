package com.bridgelabz.controllers;

import com.bridgelabz.model.QuantityDTO;
import com.bridgelabz.services.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public void performAdd(QuantityDTO q1, QuantityDTO q2) {
        double result = service.add(q1, q2);
        System.out.println("Addition Result: " + result);
    }

    public void performCompare(QuantityDTO q1, QuantityDTO q2) {
        boolean result = service.compare(q1, q2);
        System.out.println("Comparison Result: " + result);
    }
}