package project1_T4.timkiem.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import project1_T4.timkiem.builder.BuildingSearchBuilder;
import project1_T4.timkiem.utils.MapUtils;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder (Map<String,Object> params, List<String> typeCode) {
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				.setName(MapUtils.getObject(params, "name", String.class))
				
				.setFloorArea(MapUtils.getObject(params, "floorarea", Long.class))
				
				.setDistrictid(MapUtils.getObject(params, "districtId", Long.class))
				
				.setNumberOfBasement(MapUtils.getObject(params, "numberOfBasement", Long.class))
				
				.setManagerName(MapUtils.getObject(params, "managerName", String.class))
				
				.setManagerPhonenumber(MapUtils.getObject(params, "managerPhonenumber", String.class))
				
				.setRentFeeOFMaximum(MapUtils.getObject(params, "rentFeeOfMaximum", Long.class))
				
				.setRentFeeOFMinimum(MapUtils.getObject(params, "rentFeeOfMinimum", Long.class))
				
				.setAreaOfBegin(MapUtils.getObject(params, "areaOfBegin", Long.class))
				
				.setAreaOfEnd(MapUtils.getObject(params, "areaOfEnd", Long.class))
				
				.setStaffId(MapUtils.getObject(params, "staffId", Long.class))
				
				.setStreet(MapUtils.getObject(params, "street", String.class))
				
				.setTypeOfCode(typeCode)
				
				.setWard(MapUtils.getObject(params, "ward", String.class))
				
				.setLevel(MapUtils.getObject(params, "level", Long.class))
				.Build();
		
		return builder;
		
	}
}
