package project1_T4.timkiem.repository;

import java.util.List;
import java.util.Map;

import project1_T4.timkiem.repository.entity.BuildingEntity;
import project1_T4.timkiem.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	 List<RentAreaEntity> findByParamsRentArea(Integer id);
}
