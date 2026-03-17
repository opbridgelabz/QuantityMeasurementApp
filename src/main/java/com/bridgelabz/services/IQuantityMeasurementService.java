package com.bridgelabz.services;

import com.bridgelabz.model.QuantityDTO;

public interface IQuantityMeasurementService {
    double add(QuantityDTO q1, QuantityDTO q2);
    boolean compare(QuantityDTO q1, QuantityDTO q2);
}