package com.bridgelabz.services;

import com.bridgelabz.enums.LengthUnit;
import com.bridgelabz.enums.MeasurementType;
import com.bridgelabz.enums.WeightUnit;
import com.bridgelabz.exception.QuantityMeasurementException;
import com.bridgelabz.model.*;
import com.bridgelabz.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    private double convertToBase(QuantityDTO dto) {
        if (dto.type.equalsIgnoreCase("LENGTH")) {
            return LengthUnit.valueOf(dto.unit).toBase(dto.value);
        } else if (dto.type.equalsIgnoreCase("WEIGHT")) {
            return WeightUnit.valueOf(dto.unit).toBase(dto.value);
        }
        throw new QuantityMeasurementException("Invalid Type");
    }

    @Override
    public double add(QuantityDTO q1, QuantityDTO q2) {

        if (!q1.type.equals(q2.type)) {
            throw new QuantityMeasurementException("Different types not allowed");
        }

        double result = convertToBase(q1) + convertToBase(q2);

        repository.save(new QuantityMeasurementEntity(
                new QuantityModel(q1.value, q1.unit, q1.type),
                new QuantityModel(q2.value, q2.unit, q2.type),
                "ADD",
                result
        ));

        return result;
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        if (!q1.type.equals(q2.type)) {
            throw new QuantityMeasurementException("Different types not allowed");
        }

        return convertToBase(q1) == convertToBase(q2);
    }
}