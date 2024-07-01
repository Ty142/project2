package project1_T4.timkiem.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "rentarea")
public class RentAreaEntity {
	
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "value")
    private Integer value;
    
//    @Column(name = "buildingid")
//    private Integer buildingId;
//    
    @Column(name = "createddate")
    private LocalDateTime createdDate;
    
    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;
    
    @Column(name = "createdby")
    private String createdBy;
    
    @Column(name = "modifiedby")
    private String modifiedBy;
    
    @Column(name = "areaofbegin")
    private Long areaOfBegin;
    
    @Column(name = "areaofend")
    private Long areaOfEnd;
    
    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity building;
    
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
