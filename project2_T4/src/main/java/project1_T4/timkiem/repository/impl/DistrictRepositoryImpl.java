package project1_T4.timkiem.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import project1_T4.timkiem.repository.DistrictRepository;
import project1_T4.timkiem.repository.entity.DistrictEntity;
import project1_T4.timkiem.utils.ConectionUtils;


@Repository
public class DistrictRepositoryImpl implements DistrictRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "duy khang";
	@Override
	public DistrictEntity findDistrictParam(Long id) {
		DistrictEntity districts = new DistrictEntity();
		String sql = "SELECT d.* FROM district d WHERE d.id = " + id;
	    try (Connection conn = ConectionUtils.getConnection()) {
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				    districts.setName(rs.getString("name"));
			    }		 
			 } catch (SQLException e) {
		            e.printStackTrace();
		            System.out.println("Failed to connect to the database.");
		        }	
		return districts;
	}
	
}
