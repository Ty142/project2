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
import project1_T4.timkiem.utils.ConectionUtils;





@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "duy khang";

	@Override
	public List<RentAreaEntity> findByParamsRentArea(Integer id) {
		List<RentAreaEntity> results = new ArrayList<>();
		String sql = "SELECT a.* FROM rentarea a WHERE a.id = " + id;
		try (Connection conn = ConectionUtils.getConnection()) {
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				    RentAreaEntity rentareaentities = new RentAreaEntity();
				    rentareaentities.setValue(rs.getInt("value"));
				    rentareaentities.setId(rs.getInt("id"));
				    results.add(rentareaentities);
			    }		 
			 } catch (SQLException e) {
		            e.printStackTrace();
		            System.out.println("Failed to connect to the database.");
		        }	
		return results;
	}

}
