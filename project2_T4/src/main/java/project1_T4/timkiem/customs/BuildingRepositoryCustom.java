package project1_T4.timkiem.customs;

import java.util.List;

import project1_T4.timkiem.builder.BuildingSearchBuilder;
import project1_T4.timkiem.repository.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findByParams(BuildingSearchBuilder builder);
}
