package project1_T4.timkiem.service;

import java.util.List;
import java.util.Map;

import project1_T4.timkiem.controller.dto.BuildingResponseDTO;

public interface BuildingService {
	List<BuildingResponseDTO> getBuildings(Map<String, Object> params);
	List<BuildingResponseDTO> getBuildingByTypeCode(List<String> typeCode);
	
}
