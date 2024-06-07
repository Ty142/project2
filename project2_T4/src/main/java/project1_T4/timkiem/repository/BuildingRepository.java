package project1_T4.timkiem.repository;

import java.util.List;
import java.util.Map;

import project1_T4.timkiem.repository.entity.BuildingEntity;

public interface BuildingRepository {
   List<BuildingEntity> findByParams(Map<String, Object> params);
   List<BuildingEntity> findByListType( List<String> typeBuilding);

}
