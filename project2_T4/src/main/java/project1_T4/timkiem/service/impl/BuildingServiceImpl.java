package project1_T4.timkiem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project1_T4.timkiem.builder.BuildingSearchBuilder;
import project1_T4.timkiem.controller.dto.BuildingResponseDTO;
import project1_T4.timkiem.converter.BuildingConverter;
import project1_T4.timkiem.converter.BuildingSearchBuilderConverter;
import project1_T4.timkiem.repository.BuildingRepository;
import project1_T4.timkiem.repository.DistrictRepository;
import project1_T4.timkiem.repository.RentAreaRepository;
import project1_T4.timkiem.repository.UserRepository;
import project1_T4.timkiem.repository.entity.BuildingEntity;
import project1_T4.timkiem.repository.entity.DistrictEntity;
import project1_T4.timkiem.repository.entity.RentAreaEntity;
import project1_T4.timkiem.service.BuildingService;



@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
    
    @Autowired
    private BuildingConverter buildingConverter;
    
    @Override
    public List<BuildingResponseDTO> getBuildings(Map<String, Object> params, List<String> typeOfBuilding) {
    	BuildingSearchBuilder builder = buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeOfBuilding);
        List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>(); 
                List<BuildingEntity> buildings = buildingRepository.findByParams(builder);
                for (BuildingEntity it : buildings) {              
                    BuildingResponseDTO buildingResponseDTO = buildingConverter.BuildingResponseDTO(it);  
                    results.add(buildingResponseDTO);
                }

        return results;
    }




	
}