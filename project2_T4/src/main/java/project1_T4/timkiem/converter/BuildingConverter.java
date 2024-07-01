package project1_T4.timkiem.converter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import project1_T4.timkiem.controller.dto.BuildingResponseDTO;
import project1_T4.timkiem.repository.DistrictRepository;
import project1_T4.timkiem.repository.RentAreaRepository;
import project1_T4.timkiem.repository.entity.BuildingEntity;
import project1_T4.timkiem.repository.entity.DistrictEntity;
import project1_T4.timkiem.repository.entity.RentAreaEntity;


@Component
public class BuildingConverter {

	
    
    @Autowired
    private ModelMapper modelMapper;
    
	public BuildingResponseDTO BuildingResponseDTO(BuildingEntity it) {
		BuildingResponseDTO buildingResponseDTO = modelMapper.map(it, BuildingResponseDTO.class);
        buildingResponseDTO.setAddress(it.getStreet() + "," + it.getWard() + "," + it.getDistrict().getName());
        buildingResponseDTO.setRentarea(it.getRens().stream().map(i -> i.getValue().toString()).collect(Collectors.joining(",")));
		return buildingResponseDTO;
		
	}
}
