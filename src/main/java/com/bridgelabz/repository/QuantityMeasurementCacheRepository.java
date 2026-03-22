package com.bridgelabz.repository;

import com.bridgelabz.model.QuantityMeasurementEntity;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

    private static QuantityMeasurementCacheRepository instance;
    private List<QuantityMeasurementEntity> list = new ArrayList<>();

    private QuantityMeasurementCacheRepository() {
    	
    }

    
    public static QuantityMeasurementCacheRepository getInstance() {
        if (instance == null) {
            instance = new QuantityMeasurementCacheRepository();
        }
        return instance;
    }

    
    @Override
    public void save(QuantityMeasurementEntity entity) {
        list.add(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {
        return list;
    }

	@Override
	public void deleteAll() {
		list.clear();
	}

	@Override
	public int getTotalCount() {
		return list.size();
	}
}