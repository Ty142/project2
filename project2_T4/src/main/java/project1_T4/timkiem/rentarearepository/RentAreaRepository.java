package project1_T4.timkiem.rentarearepository;

import java.util.List;
import java.util.Map;

import project1_T4.timkiem.rentarearepository.entity.RentAreaEntity;
import project1_T4.timkiem.repository.entity.BuildingEntity;

public interface RentAreaRepository {
	 List<RentAreaEntity> findByParamsRentArea(Integer id);
}
