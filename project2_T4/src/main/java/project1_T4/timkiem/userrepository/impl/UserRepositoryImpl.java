package project1_T4.timkiem.userrepository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import project1_T4.timkiem.userrepository.UserRepository;
import project1_T4.timkiem.userrepository.entity.UserEntity;



@Repository
public class UserRepositoryImpl implements UserRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "duy khang";
	@Override
	public List<UserEntity> findUserIdByFullName(String fullname) {
		List<UserEntity> users = new ArrayList<UserEntity>();
		String sql = "SELECT a.* FROM user a ";
		String where = " WHERE 1=1 ";  
		if (fullname != null && fullname != "") {
	        where += " AND a.fullname = " + fullname;
	    }
	  sql += where;
	  try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS )) {
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery(sql);
		 while(rs.next()) {
			 UserEntity user = new UserEntity();
			 user.setId(rs.getLong("id"));
		 }
	  } catch (SQLException e) {
          e.printStackTrace();
          System.out.println("Failed to connect to the database.");
      }	


	return users;
} 
	}