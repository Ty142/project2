package project1_T4.timkiem.repository.impl;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import project1_T4.timkiem.repository.BuildingRepository;
import project1_T4.timkiem.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "duy khang";

	@Override
	public List<BuildingEntity> findByParams(Map<String, Object> params,List<String> typeOfBuilding) {
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		String sql = "SELECT DISTINCT b.* FROM building b ";
		String where = " WHERE 1=1 ";
		String join = "";
		
		if(params != null) {
			    if (params.containsKey("buildingname") && params.get("buildingname") !="" && params.get("buildingname") !=null) {
	                where += " AND b.name LIKE '%" + params.get("buildingname") + "%'";
	            }
	            if (params.containsKey("ward") && params.get("ward") != null && params.get("ward") !="") {
	                where += " AND b.ward LIKE '%" + params.get("ward") + "%'";
	            }
	            if (params.containsKey("street") && params.get("street") != null && params.get("street") !="") {
	                where += " AND b.street LIKE '%" + params.get("street") + "%'";
	            }
	            if (params.containsKey("managerphonenumber") && params.get("managerphonenumber") != null && params.get("managerphonenumber") !="") {
	                where += " AND b.managerphonenumber LIKE '%" + params.get("managerphonenumber") + "%'";
	            }
	            if (params.containsKey("managername") && params.get("managername") != null && params.get("managername") !="") {
	                where += " AND b.managername LIKE '%" + params.get("managername") + "%'";
	            }
	            if (params.containsKey("level") && params.get("level") != null && params.get("level") !="") {
	                where += " AND b.level LIKE '%" + params.get("level") + "%'";
	            }
	            if (params.containsKey("floorarea") && params.get("floorarea") != null && params.get("floorarea") !="") {
	                where += " AND b.floorarea LIKE '%" + params.get("floorarea") + "%'";
	            }	
	            if (params.containsKey("staffId") && params.get("staffId") != null && params.get("staffId") != "") {
	            	where += " AND u.id = " + params.get("staffId");
	            	join += " INNER JOIN assignmentbuilding sb ON b.id = sb.buildingid "
	            	        + "INNER JOIN user u ON sb.staffid = u.id";
	            }	
	            if (params.containsKey("areaOfBegin") && params.get("areaOfBegin") != null) {
	            	where += " AND ra.value >= " + params.get("areaOfBegin");
	            	if (params.containsKey("areaOfEnd") && params.get("areaOfEnd") != null) {
	            		where += " AND ra.value <= " + params.get("areaOfEnd");
	            	}
	            	join += " INNER JOIN rentarea ra On  ra.buildingid = b.id";
	            }
	            if (params.containsKey("rentFeeOfMinimum") && params.get("rentFeeOfMinimum") != null) {
	            	where += " AND b.rentprice >= " + params.get("rentFeeOfMinimum");
	            	if (params.containsKey("rentFeeOfMaximum") && params.get("rentFeeOfMaximum") != null) {
	            		where += " AND b.rentprice <= " + params.get("rentFeeOfMaximum");
	            	}
	            }
	            if (typeOfBuilding != null && !typeOfBuilding.isEmpty()) {
			        join += " INNER JOIN buildingrenttype sb ON b.id = sb.buildingid "
			              + "INNER JOIN renttype t ON sb.renttypeid = t.id";
			        String typeCondition = String.join("','", typeOfBuilding);
			        where += " AND t.name IN ('" + typeCondition + "')";
			        
			    }
	            
		}
	           
		if (!join.isEmpty()) {
		    sql += join;
		}

		sql += where;
		
		
		try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS )) {
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			
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



