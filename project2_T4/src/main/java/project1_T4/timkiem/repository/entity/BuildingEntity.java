package project1_T4.timkiem.repository.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "ward")
    private String ward;
    
//    @Column(name = "districtid")
//    private long districtId;
    
    @ManyToOne
    @JoinColumn(name = "districtid")
    private DistrictEntity district;
    
    
    @Column(name = "structure")
    private String structure;
    
    @Column(name = "numberofbasement")
    private int numberOfBasement;
    
    @Column(name = "floorarea")
    private int floorArea;
    
    @Column(name = "direction")
    private String direction;
    
    @Column(name = "level")
    private String level;
    
    @Column(name = "rentprice")
    private int rentPrice;
    
    @Column(name = "rentpricedescription")
    private String rentPriceDescription;
    
    @Column(name = "servicefee")
    private String serviceFee;
    
    @Column(name = "carfee",nullable = true)
    private String carFee;
    
    @Column(name = "motorbikefee",nullable = true)
    private String motorbikeFee;
    
    @Column(name = "overtimefee",nullable = true)
    private String overtimeFee;
    
    @Column(name = "waterfee",nullable = true)
    private String waterFee;
    
    @Column(name = "electricityfee",nullable = true)
    private String electricityFee;
    
    @Column(name = "deposit",nullable = true)
    private String deposit;
    
    @Column(name = "payment",nullable = true)
    private String payment;
    
    @Column(name = "renttime",nullable = true)
    private String rentTime;
    
    @Column(name = "decorationtime",nullable = true)
    private String decorationTime;
    
    @Column(name = "brokeragefee",nullable = true)
    private BigDecimal brokerageFee;
    
    @Column(name = "note",nullable = true)
    private String note;
    
    @Column(name = "linkofbuilding",nullable = true)
    private String linkOfBuilding;
    
    @Column(name = "map",nullable = true)
    private String map;
    
    @Column(name = "image",nullable = true)
    private String image;
    
    @Column(name = "createddate",nullable = true)
    private LocalDateTime createdDate;
    
    @Column(name = "modifieddate",nullable = true)
    private LocalDateTime modifiedDate;
    
    @Column(name = "createdby",nullable = true)
    private String createdBy;
    
    @Column(name = "modifiedby",nullable = true)
    private String modifiedBy;
    
    @Column(name = "managername",nullable = true)
    private String managerName;
    
    @Column(name = "managerphonenumber",nullable = true)
    private String managerPhoneNumber;
    
    
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<RentAreaEntity> rens = new ArrayList<RentAreaEntity>();

    public List<RentAreaEntity> getRens() {
		return rens;
	}

	public void setRens(List<RentAreaEntity> rens) {
		this.rens = rens;
	}


	// Getters and Setters for all fields
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }


    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public int getNumberofbasement() {
        return numberOfBasement;
    }

    public void setNumberofbasement(int numberofbasement) {
        this.numberOfBasement = numberofbasement;
    }

    public int getFloorarea() {
        return floorArea;
    }

    public void setFloorarea(int floorarea) {
        this.floorArea = floorarea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getRentprice() {
        return rentPrice;
    }

    public void setRentprice(int rentprice) {
        this.rentPrice = rentprice;
    }

    public String getRentpricedescription() {
        return rentPriceDescription;
    }

    public void setRentpricedescription(String rentpricedescription) {
        this.rentPriceDescription = rentpricedescription;
    }

    public String getServicefee() {
        return serviceFee;
    }

    public void setServicefee(String servicefee) {
        this.serviceFee = servicefee;
    }

    public String getCarfee() {
        return carFee;
    }

    public void setCarfee(String carfee) {
        this.carFee = carfee;
    }

    public String getMotorbikefee() {
        return motorbikeFee;
    }

    public void setMotorbikefee(String motorbikefee) {
        this.motorbikeFee = motorbikefee;
    }

    public String getOvertimefee() {
        return overtimeFee;
    }

    public void setOvertimefee(String overtimefee) {
        this.overtimeFee = overtimefee;
    }

    public String getWaterfee() {
        return waterFee;
    }

    public void setWaterfee(String waterfee) {
        this.waterFee = waterfee;
    }

    public String getElectricityfee() {
        return electricityFee;
    }

    public void setElectricityfee(String electricityfee) {
        this.electricityFee = electricityfee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRenttime() {
        return rentTime;
    }

    public void setRenttime(String renttime) {
        this.rentTime = renttime;
    }

    public String getDecorationtime() {
        return decorationTime;
    }

    public void setDecorationtime(String decorationtime) {
        this.decorationTime = decorationtime;
    }

    public BigDecimal getBrokeragefee() {
        return brokerageFee;
    }

    public void setBrokeragefee(BigDecimal brokeragefee) {
        this.brokerageFee = brokeragefee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkofbuilding() {
        return linkOfBuilding;
    }

    public void setLinkofbuilding(String linkofbuilding) {
        this.linkOfBuilding = linkofbuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreateddate() {
        return createdDate;
    }

    public void setCreateddate(LocalDateTime createddate) {
        this.createdDate = createddate;
    }

    public LocalDateTime getModifieddate() {
        return modifiedDate;
    }

    public void setModifieddate(LocalDateTime modifieddate) {
        this.modifiedDate = modifieddate;
    }

    public String getCreatedby() {
        return createdBy;
    }

    public void setCreatedby(String createdby) {
        this.createdBy = createdby;
    }

    public String getModifiedby() {
        return modifiedBy;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedBy = modifiedby;
    }

    public String getManagername() {
        return managerName;
    }

    public void setManagername(String managername) {
        this.managerName = managername;
    }

    public String getManagerphonenumber() {
        return managerPhoneNumber;
    }

    public void setManagerphonenumber(String managerphonenumber) {
        this.managerPhoneNumber = managerphonenumber;
    }

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
    
    
}

