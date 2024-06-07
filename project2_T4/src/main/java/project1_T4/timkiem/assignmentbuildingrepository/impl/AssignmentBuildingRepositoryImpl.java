package project1_T4.timkiem.assignmentbuildingrepository.impl;

import org.springframework.stereotype.Repository;

import project1_T4.timkiem.assignmentbuildingrepository.AssignmentBuildingRepository;
import project1_T4.timkiem.assignmentbuildingrepository.entity.AssignmentBuildingEntity;
@Repository
public class AssignmentBuildingRepositoryImpl implements AssignmentBuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "duy khang";
	@Override
	public AssignmentBuildingRepository findBuildingByUserId(Long id) {
		AssignmentBuildingEntity idUser = new AssignmentBuildingEntity();
		String sql = "SELECT a.* FROM assignmentbuilding a ";
		String where = " WHERE 1=1 ";
	    if (id != null && id != 0) {
		        where += " AND a.buildingid = " + id;
		    }
		return null;
	}

}
