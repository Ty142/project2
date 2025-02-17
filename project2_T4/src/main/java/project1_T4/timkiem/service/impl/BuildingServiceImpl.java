package project1_T4.timkiem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project1_T4.timkiem.assignmentbuildingrepository.AssignmentBuildingRepository;
import project1_T4.timkiem.controller.dto.BuildingResponseDTO;
import project1_T4.timkiem.districtrepository.DistrictRepository;
import project1_T4.timkiem.districtrepository.entity.DistrictEntity;
import project1_T4.timkiem.rentarearepository.RentAreaRepository;
import project1_T4.timkiem.rentarearepository.entity.RentAreaEntity;
import project1_T4.timkiem.repository.BuildingRepository;

import project1_T4.timkiem.repository.entity.BuildingEntity;

import project1_T4.timkiem.service.BuildingService;
import project1_T4.timkiem.userrepository.UserRepository;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private RentAreaRepository rentAreaRepository;
    
    @Autowired
    private DistrictRepository districtRepository;
    
    @Autowired
    private AssignmentBuildingRepository assignMent;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<BuildingResponseDTO> getBuildings(Map<String, Object> params) {
        List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();

           
          
            	
                List<BuildingEntity> buildings = buildingRepository.findByParams(params);

                for (BuildingEntity it : buildings) {
                
                    BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
                    buildingResponseDTO.setNameb(it.getName());
                    Long districtid = it.getDistrictid();
                    DistrictEntity districtdname = districtRepository.findDistrictParam(districtid);
                    buildingResponseDTO.setAddress(it.getStreet() + "," + it.getWard() + "," + districtdname.getName());
                    buildingResponseDTO.setNumberofbasement(it.getNumberofbasement());
                    buildingResponseDTO.setManagername(it.getManagername());
                    buildingResponseDTO.setManagerphonenumber(it.getManagerphonenumber());
                    buildingResponseDTO.setFloorarea(it.getFloorarea());
                    Integer buildingId = it.getId();
                    List<RentAreaEntity> rentAreas = rentAreaRepository.findByParamsRentArea(buildingId);
                    StringBuilder rentAreaValues = new StringBuilder();

                    for (RentAreaEntity that : rentAreas) {
                        if (rentAreaValues.length() > 0) {
                            rentAreaValues.append(", ");
                        }
                        rentAreaValues.append(String.valueOf(that.getValue()));
                    }
                    

                    buildingResponseDTO.setRentarea(rentAreaValues.toString());
                    buildingResponseDTO.setRentprice(it.getRentprice());
                    results.add(buildingResponseDTO);
                }
            
        

        
        return results;
    }

	@Override
	public List<BuildingResponseDTO> getBuildingByTypeCode(List<String> typeCode) {
		 List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();

         
         
     	
         List<BuildingEntity> buildings = buildingRepository.findByListType(typeCode);

         for (BuildingEntity it : buildings) {
         
             BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
             buildingResponseDTO.setNameb(it.getName());
             Long districtid = it.getDistrictid();
             DistrictEntity districtdname = districtRepository.findDistrictParam(districtid);
             buildingResponseDTO.setAddress(it.getStreet() + "," + it.getWard() + "," + districtdname.getName());
             buildingResponseDTO.setNumberofbasement(it.getNumberofbasement());
             buildingResponseDTO.setManagername(it.getManagername());
             buildingResponseDTO.setManagerphonenumber(it.getManagerphonenumber());
             buildingResponseDTO.setFloorarea(it.getFloorarea());
             Integer buildingId = it.getId();
             List<RentAreaEntity> rentAreas = rentAreaRepository.findByParamsRentArea(buildingId);
             StringBuilder rentAreaValues = new StringBuilder();

             for (RentAreaEntity that : rentAreas) {
                 if (rentAreaValues.length() > 0) {
                     rentAreaValues.append(", ");
                 }
                 rentAreaValues.append(String.valueOf(that.getValue()));
             }
             

             buildingResponseDTO.setRentarea(rentAreaValues.toString());
             buildingResponseDTO.setRentprice(it.getRentprice());
             results.add(buildingResponseDTO);
         }
 return results;
	}

	
}