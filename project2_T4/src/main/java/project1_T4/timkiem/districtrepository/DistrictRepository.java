package project1_T4.timkiem.districtrepository;

import project1_T4.timkiem.districtrepository.entity.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findDistrictParam(Long id);
}
