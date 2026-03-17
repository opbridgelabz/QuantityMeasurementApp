package com.bridgelabz;

import com.bridgelabz.controllers.QuantityMeasurementController;
import com.bridgelabz.exception.QuantityMeasurementException;
import com.bridgelabz.model.QuantityDTO;
import com.bridgelabz.model.QuantityMeasurementEntity;
import com.bridgelabz.repository.QuantityMeasurementCacheRepository;
import com.bridgelabz.services.IQuantityMeasurementService;
import com.bridgelabz.services.QuantityMeasurementServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private IQuantityMeasurementService service;
    private QuantityMeasurementController controller;

    @BeforeEach
    void setUp() {
        service = new QuantityMeasurementServiceImpl(
                QuantityMeasurementCacheRepository.getInstance()
        );
        controller = new QuantityMeasurementController(service);
    }

    // ================= ENTITY TESTS =================

    @Test
    void testQuantityEntity_BinaryOperandConstruction() {
        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(null, null, "ADD", 10);

        assertNotNull(entity);
    }

    @Test
    void testQuantityEntity_ErrorConstruction() {
        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity("Error occurred");

        assertNotNull(entity);
    }

    // ================= SERVICE TESTS =================

    @Test
    void testService_CompareEquality_SameUnit_Success() {
        QuantityDTO q1 = new QuantityDTO(10, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(10, "FEET", "LENGTH");

        assertTrue(service.compare(q1, q2));
    }

    @Test
    void testService_CompareEquality_DifferentUnit_Success() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        assertTrue(service.compare(q1, q2));
    }

    @Test
    void testService_CompareEquality_CrossCategory_Error() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(1, "KG", "WEIGHT");

        assertThrows(QuantityMeasurementException.class,
                () -> service.compare(q1, q2));
    }

    @Test
    void testService_Add_Success() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        double result = service.add(q1, q2);

        assertEquals(24.0, result);
    }

    @Test
    void testService_Add_CrossCategory_Error() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(1, "KG", "WEIGHT");

        assertThrows(QuantityMeasurementException.class,
                () -> service.add(q1, q2));
    }

    @Test
    void testService_UsesExistingLogic_Addition() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        double result = service.add(q1, q2);

        assertEquals(24.0, result);
    }
    
    
    
    // ================= CONTROLLER TESTS =================

    @Test
    void testController_DemonstrateAddition_Success() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        assertDoesNotThrow(() -> controller.performAdd(q1, q2));
    }

    @Test
    void testController_DemonstrateAddition_Error() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(1, "KG", "WEIGHT");

        assertThrows(Exception.class,
                () -> controller.performAdd(q1, q2));
    }

    @Test
    void testController_DemonstrateEquality_Success() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        assertDoesNotThrow(() -> controller.performCompare(q1, q2));
    }

    @Test
    void testController_CallsService() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        assertDoesNotThrow(() -> controller.performAdd(q1, q2));
    }
    
    // ================= LAYER TESTS =================

    @Test
    void testLayerSeparation_ServiceIndependence() {
        QuantityDTO q1 = new QuantityDTO(5, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(60, "INCH", "LENGTH");

        assertTrue(service.compare(q1, q2));
    }

    @Test
    void testLayerSeparation_ControllerIndependence() {
        IQuantityMeasurementService mockService =
                new QuantityMeasurementServiceImpl(
                        QuantityMeasurementCacheRepository.getInstance()
                );

        QuantityMeasurementController mockController =
                new QuantityMeasurementController(mockService);

        assertNotNull(mockController);
    }

    // ================= DATA FLOW =================

    @Test
    void testDataFlow_ControllerToService() {
        QuantityDTO q1 = new QuantityDTO(2, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(24, "INCH", "LENGTH");

        assertDoesNotThrow(() -> controller.performCompare(q1, q2));
    }

    @Test
    void testDataFlow_ServiceToController() {
        QuantityDTO q1 = new QuantityDTO(2, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(24, "INCH", "LENGTH");

        boolean result = service.compare(q1, q2);

        assertTrue(result);
    }

    // ================= INTEGRATION =================

    @Test
    void testIntegration_EndToEnd_LengthAddition() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12, "INCH", "LENGTH");

        double result = service.add(q1, q2);

        assertEquals(24.0, result);
    }
    
    //===========repository tests=====================
    
    @Test
    void testRepository_SaveAndFetch() {
        QuantityMeasurementCacheRepository repo =
                QuantityMeasurementCacheRepository.getInstance();

        repo.save(new QuantityMeasurementEntity(null, null, "ADD", 10));

        assertFalse(repo.findAll().isEmpty());
    }

    // ================= VALIDATION =================

    @Test
    void testService_NullEntity_Rejection() {
        assertThrows(Exception.class,
                () -> service.add(null, null));
    }
    
    
    //==============Exception test============
    @Test
    void testService_ExceptionHandling() {
        QuantityDTO q1 = new QuantityDTO(1, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(1, "KG", "WEIGHT");

        assertThrows(Exception.class, () -> service.add(q1, q2));
    }
}