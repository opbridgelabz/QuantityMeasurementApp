package com.bridgelabz.app;

import com.bridgelabz.controllers.QuantityMeasurementController;
import com.bridgelabz.model.QuantityDTO;
import com.bridgelabz.repository.QuantityMeasurementCacheRepository;
import com.bridgelabz.services.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementCacheRepository repo = QuantityMeasurementCacheRepository.getInstance();

        QuantityMeasurementServiceImpl service = new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller = new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        controller.performCompare(q1, q2);
        controller.performAdd(q1, q2);
    }
}