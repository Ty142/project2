package project1_T4.timkiem.repository.impl;

import java.lang.reflect.Field;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import project1_T4.timkiem.utils.ConectionUtils;
import project1_T4.timkiem.utils.NumberUtils;
import project1_T4.timkiem.builder.BuildingSearchBuilder;
import project1_T4.timkiem.repository.BuildingRepository;
import project1_T4.timkiem.repository.entity.BuildingEntity;
import project1_T4.timkiem.utils.StringUtils;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "duy khang";

	public void querySQLJoin(BuildingSearchBuilder builder,StringBuilder join) {
		Long staffId = builder.getStaffId();
		if (staffId != null) {
			join.append(" INNER JOIN assignmentbuilding sb ON b.id = sb.buildingid ");
		}
		Long areaBegin = builder.getRentOfBegin();
		Long areaEnd = builder.getRentOfEnd();
		if (areaBegin != null || areaEnd != null) {
			join.append(" INNER JOIN rentarea ra On  ra.buildingid = b.id");
		}
		
		if (builder.getTypeOfCode() != null && !builder.getTypeOfCode().isEmpty()) {
			join.append(" INNER JOIN buildingrenttype br ON b.id = br.buildingid ");
			join.append("INNER JOIN renttype t ON br.renttypeid = t.id ");
		}
		
		Long districtId = builder.getDistrictid();
		if (districtId != null) {
			join.append(" INNER JOIN district d on d.id = b.districtid");
		}
	}
	
	public void querySQLNomal(BuildingSearchBuilder builder,StringBuilder where) {
			try {
				Field [] fields = BuildingSearchBuilder.class.getFields();
				for (Field item : fields) {
					item.setAccessible(true);
					String fieldName = item.getName();
					if (!fieldName.equals("staffId") && !fieldName.equals("areaOfBegin") && !fieldName.equals("areaOfEnd") && !fieldName.startsWith("typeOfBuilding") && !fieldName.startsWith("districtName") && !fieldName.startsWith("rentFeeOf")) {
						Object value = item.get(builder);
						if (value != null) {
							if (item.getType().getName().equals("java.lang.Long")) {
								where.append(" AND b." + fieldName.toLowerCase() + " = " + value);
							}
							else if (item.getType().getName().equals("java.lang.String")) {
								where.append(" AND b." + fieldName.toLowerCase() + " like '%" + value+ "%'");
							}
						}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void querySQLSpecial(BuildingSearchBuilder builder,StringBuilder where) {
		Long areaBegin = builder.getRentOfBegin();
		Long areaEnd = builder.getRentOfEnd();
		if (areaBegin != null || areaEnd!= null) {
			where.append(" AND EXISTS (SELECT * FROM rentarea ra on ra.buildingid = b.id "); 
			if (areaBegin != null) {
				where.append(" AND ra.value >= " + areaBegin);
			}
			if (areaEnd != null) {
				where.append(" AND ra.value <= " + areaEnd);
			}
			where.append(")");
		}
		Long staffId = builder.getStaffId();
		if (staffId != null) {
			where.append(" AND sb.staffId = " + staffId);
		}
		
		Long rentFeeOfMinimum = builder.getRentFeeMinimum();
		Long rentFeeOfMaximum = builder.getRentFeeMinimum();
		if (rentFeeOfMinimum != null) {
			where.append(" AND b.rentprice >= " + rentFeeOfMinimum);
		}
		if (rentFeeOfMaximum != null) {
			where.append(" AND b.rentprice <= " + rentFeeOfMaximum);
		}
		
//		if (typeOfCode != null && !typeOfCode.equals("")) {
//			List<String> name = new ArrayList<String>();
//			for ( String it : typeOfCode) {
//				name.add("'" + it + "'");
//			}
//			where.append(" AND t.name IN (" + String.join(",",name) + ") " );
//		}
		
		//java 8
		List<String> typeOfCode = builder.getTypeOfCode();
		if (typeOfCode != null && !typeOfCode.equals("")) {
			where.append(" AND (");
			where.append(typeOfCode.stream().map(item -> "t.name like '%" + item + "%'").collect(Collectors.joining(" OR ")));
			where.append(")");
		}
		
		
		Long districtId = builder.getDistrictid();
		if (districtId != null) {
			where.append(" AND d.name like '%" + districtId + "%'");
		}
	}
	@Override
	public List<BuildingEntity> findByParams(BuildingSearchBuilder builder) {
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		StringBuilder sql = new StringBuilder("SELECT DISTINCT b.* FROM building b ");
		StringBuilder where = new StringBuilder( " WHERE 1=1 ");
		querySQLNomal( builder, where);
		querySQLJoin(builder, sql);
		querySQLSpecial(builder, where);
		sql.append(where);
		try (Connection conn = ConectionUtils.getConnection()) {
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql.toString());
			
			 while(rs.next()) {
				    BuildingEntity building = new BuildingEntity();
				    building.setId(rs.getInt("id"));
				    building.setName(rs.getString("name"));
	                building.setStreet(rs.getString("street"));
	                building.setWard(rs.getString("ward"));
	                building.setDistrictid(rs.getLong("districtid"));
	                building.setStructure(rs.getString("structure"));
	                building.setNumberofbasement(rs.getInt("numberofbasement"));
	                building.setFloorarea(rs.getInt("floorarea"));
	                building.setDirection(rs.getString("direction"));
	                building.setLevel(rs.getString("level"));
	                building.setRentprice(rs.getInt("rentprice"));
	                building.setManagername(rs.getString("managername"));
	                building.setManagerphonenumber(rs.getString("managerphonenumber"));
	                results.add(building);
				 
			 }
		}   catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        
		}

		return results;
	}
	




}



