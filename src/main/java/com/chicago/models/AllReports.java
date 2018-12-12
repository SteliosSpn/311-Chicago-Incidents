package com.chicago.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "all_reports")
public class AllReports implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int report_id;
	
	private Timestamp creation_date;
	private String status;
	private Timestamp completion_date;
	private String service_request_number;
	private String type_of_service_request;
	@NotEmpty
	private String street_address;
	private int zip_code;
	private int x_coord;
	private int y_coord;
	private short ward;
	private short police_district;
	private short community_area;
	private double latitude;
	private double longitude;
	private String location_desc;
	
	public AllReports() {
		
	}
	
	public AllReports(int zip_code){
		this.zip_code = zip_code;
	}
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCompletion_date() {
		return completion_date;
	}
	public void setCompletion_date(Timestamp completion_date) {
		this.completion_date = completion_date;
	}
	public String getService_request_number() {
		return service_request_number;
	}
	public void setService_request_number(String service_request_number) {
		this.service_request_number = service_request_number;
	}
	public String getType_of_service_request() {
		return type_of_service_request;
	}
	public void setType_of_service_request(String type_of_service_request) {
		this.type_of_service_request = type_of_service_request;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public int getX_coord() {
		return x_coord;
	}
	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}
	public int getY_coord() {
		return y_coord;
	}
	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}
	public short getWard() {
		return ward;
	}
	public void setWard(short ward) {
		this.ward = ward;
	}
	public short getPolice_district() {
		return police_district;
	}
	public void setPolice_district(short police_district) {
		this.police_district = police_district;
	}
	public short getCommunity_area() {
		return community_area;
	}
	public void setCommunity_area(short community_area) {
		this.community_area = community_area;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLocation_desc() {
		return location_desc;
	}
	public void setLocation_desc(String location_desc) {
		this.location_desc = location_desc;
	}
	
	
	
}