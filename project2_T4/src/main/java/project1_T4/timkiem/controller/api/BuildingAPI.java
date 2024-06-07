package project1_T4.timkiem.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project1_T4.timkiem.controller.dto.BuildingResponseDTO;
import project1_T4.timkiem.repository.BuildingRepository;
import project1_T4.timkiem.repository.entity.BuildingEntity;
import project1_T4.timkiem.service.BuildingService;


@RestController
public class BuildingAPI {
	
	@Autowired
    private BuildingService BuildingServ;
	
	@GetMapping(value="/api/buildinGs")
	private Object getBuildings(@RequestParam(required = false) Map<String,Object> params,
		                     	@RequestParam(name = "typeOfBuilding", required = false) List<String> typeBuilding){		
		 if (typeBuilding != null && !typeBuilding.isEmpty()) {
		        return BuildingServ.getBuildingByTypeCode(typeBuilding);
		    } else {
		        return BuildingServ.getBuildings(params);
		    }
	}
	
}
