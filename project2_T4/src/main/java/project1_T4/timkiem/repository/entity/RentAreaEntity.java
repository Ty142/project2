package project1_T4.timkiem.repository.entity;

import java.time.LocalDateTime;

public class RentAreaEntity {
	private Integer id;
    private Integer value;
    private Integer buildingId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Long areaOfBegin;
    private Long areaOfEnd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer i) {
		this.buildingId = i;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
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
	public Long getAreaOfBegin() {
		return areaOfBegin;
	}
	public void setAreaOfBegin(Long areaOfBegin) {
		this.areaOfBegin = areaOfBegin;
	}
	public Long getAreaOfEnd() {
		return areaOfEnd;
	}
	public void setAreaOfEnd(Long areaOfEnd) {
		this.areaOfEnd = areaOfEnd;
	}
	
}
