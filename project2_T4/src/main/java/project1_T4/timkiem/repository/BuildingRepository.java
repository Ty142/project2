package project1_T4.timkiem.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import project1_T4.timkiem.customs.BuildingRepositoryCustom;
import project1_T4.timkiem.repository.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
   

}
