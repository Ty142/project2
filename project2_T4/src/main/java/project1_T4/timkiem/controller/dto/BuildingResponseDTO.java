package project1_T4.timkiem.controller.dto;

public class BuildingResponseDTO {

	private String name;
	private String address;
	private int numberofbasement;
	private String managername;
	private String managerphonenumber;
    private int floorarea;
    private int emptyfloorarea;
    private String rentarea;
    private int rentprice;
    private int servicefee;
	public String getNameb() {
		return name;
	}
	public void setNameb(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(int numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
	public int getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(int floorarea) {
		this.floorarea = floorarea;
	}
	public int getEmptyfloorarea() {
		return emptyfloorarea;
	}
	public void setEmptyfloorarea(int emptyfloorarea) {
		this.emptyfloorarea = emptyfloorarea;
	}
	public String getRentarea() {
		return rentarea;
	}
	public void setRentarea(String string) {
		this.rentarea = string;
	}
	public int getRentprice() {
		return rentprice;
	}
	public void setRentprice(int rentprice) {
		this.rentprice = rentprice;
	}
	public int getServicefee() {
		return servicefee;
	}
	public void setServicefee(int servicefee) {
		this.servicefee = servicefee;
	} 
	
	
}
