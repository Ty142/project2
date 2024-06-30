package project1_T4.timkiem.builder;

import java.util.List;

public class BuildingSearchBuilder {
	private  String name;
	private Long floorArea;
	private String ward;
	private String street;
	private Long districtid;
	private Long numberOfBasement;
	private List<String> TypeOfCode;
	private String managerName;
	private String managerPhonenumber;
	private Long rentFeeOfMinimum;
	private Long rentFeeOfMaximum;
	private Long areaOfBegin;
	private Long areaOfEnd;
	private Long staffId;
	private Long level;
	
	
	private BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.floorArea = builder.floorArea;
		this.ward = builder.ward;
		this.street = builder.street;
		this.districtid = builder.districtid;
		this.numberOfBasement = builder.numberOfBasement;
		this.TypeOfCode = builder.TypeOfCode;
		this.managerName  = builder.managerName;
		this.managerPhonenumber = builder.managerPhonenumber;
		this.rentFeeOfMinimum = builder.rentFeeOFMinimum;
		this.rentFeeOfMaximum = builder.rentFeeOFMaximum;
		this.areaOfBegin = builder.areaOfBegin;
		this.areaOfEnd = builder.areaOfEnd;
		this.staffId = builder.staffId;
		this.level = builder.level;
		
	}
	


	public String getName() {
		return name;
	}



	public Long getFloorArea() {
		return floorArea;
	}



	public String getWard() {
		return ward;
	}



	public String getStreet() {
		return street;
	}



	public Long getDistrictid() {
		return districtid;
	}



	public Long getNumberOfBasement() {
		return numberOfBasement;
	}



	public List<String> getTypeOfCode() {
		return TypeOfCode;
	}



	public String getManagerName() {
		return managerName;
	}



	public String getManagerPhonenumber() {
		return managerPhonenumber;
	}



	public Long getRentFeeOfMinimum() {
		return rentFeeOfMinimum;
	}



	public Long getRentFeeOfMaximum() {
		return rentFeeOfMaximum;
	}



	public Long getAreaOfBegin() {
		return areaOfBegin;
	}



	public Long getAreaOfEnd() {
		return areaOfEnd;
	}



	public Long getStaffId() {
		return staffId;
	}



	public Long getLevel() {
		return level;
	}



	public static class Builder{
		private  String name;
		private Long floorArea;
		private String ward;
		private String street;
		private Long districtid;
		private Long numberOfBasement;
		private List<String> TypeOfCode;
		private String managerName;
		private String managerPhonenumber;
		private Long rentFeeOFMinimum;
		private Long rentFeeOFMaximum;
		private Long areaOfBegin;
		private Long areaOfEnd;
		private Long staffId;
		private Long level;
		
		
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}



		public Builder setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}



		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}



		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}



		public Builder setDistrictid(Long districtid) {
			this.districtid = districtid;
			return this;
		}



		public Builder setNumberOfBasement(Long numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}



		public Builder setTypeOfCode(List<String> typeOfCode) {
			TypeOfCode = typeOfCode;
			return this;
		}



		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}



		public Builder setManagerPhonenumber(String managerPhonenumber) {
			this.managerPhonenumber = managerPhonenumber;
			return this;
		}



		public Builder setRentFeeOFMinimum(Long rentFeeOFMinimum) {
			this.rentFeeOFMinimum = rentFeeOFMinimum;
			return this;
		}



		public Builder setRentFeeOFMaximum(Long rentFeeOFMaximum) {
			this.rentFeeOFMaximum = rentFeeOFMaximum;
			return this;
		}



		public Builder setAreaOfBegin(Long areaOfBegin) {
			this.areaOfBegin = areaOfBegin;
			return this;
		}



		public Builder setAreaOfEnd(Long areaOfEnd) {
			this.areaOfEnd = areaOfEnd;
			return this;
		}



		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}



		public Builder setLevel(Long level) {
			this.level = level;
			return this;
		}



		public BuildingSearchBuilder Build() {
			return new BuildingSearchBuilder(this);
		}
		
	}
	}
