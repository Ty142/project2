package project1_T4.timkiem.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import project1_T4.timkiem.repository.RentAreaRepository;
import project1_T4.timkiem.repository.entity.RentAreaEntity;





@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "duy khang";

	@Override
	public List<RentAreaEntity> findByParamsRentArea(Integer id) {
		List<RentAreaEntity> results = new ArrayList<>();
		String sql = "SELECT a.* FROM rentarea a ";
		String where = " WHERE 1=1 ";
	    if (id != null && id != 0) {
		        where += " AND a.buildingid = " + id;
		    }
		sql += where;
		try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS )) {
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				    RentAreaEntity rentareaentities = new RentAreaEntity();
				    rentareaentities.setBuildingId(rs.getInt("buildingid"));
				    rentareaentities.setCreatedBy(where);
				    rentareaentities.setCreatedDate(null);
				    rentareaentities.setId(null);
				    rentareaentities.setModifiedBy(where);
				    rentareaentities.setModifiedDate(null);
				    rentareaentities.setValue(rs.getInt("value"));
				    results.add(rentareaentities);
			    }		 
			 } catch (SQLException e) {
		            e.printStackTrace();
		            System.out.println("Failed to connect to the database.");
		        }	
		return results;
	}

}
