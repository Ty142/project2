package project1_T4.timkiem.repository.entity;

import java.sql.Timestamp;

public class AssignmentBuildingEntity {
	 private long id;
	    private long staffId;
	    private long buildingId;
	    private Timestamp createdDate;
	    private Timestamp modifiedDate;
	    private String createdBy;
	    private String modifiedBy;

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public long getStaffId() {
	        return staffId;
	    }

	    public void setStaffId(long staffId) {
	        this.staffId = staffId;
	    }

	    public long getBuildingId() {
	        return buildingId;
	    }

	    public void setBuildingId(long buildingId) {
	        this.buildingId = buildingId;
	    }

	    public Timestamp getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(Timestamp createdDate) {
	        this.createdDate = createdDate;
	    }

	    public Timestamp getModifiedDate() {
	        return modifiedDate;
	    }

	    public void setModifiedDate(Timestamp modifiedDate) {
	        this.modifiedDate = modifiedDate;
	    }

	    public String getCreatedBy() {
	        return createdBy;
	    }

	    public void setCreatedBy(String createdBy) {
	        this.createdBy = createdBy;
	    }

	    public String getModifiedBy() {
	        return modifiedBy;
	    }

	    public void setModifiedBy(String modifiedBy) {
	        this.modifiedBy = modifiedBy;
	    }
	
}
