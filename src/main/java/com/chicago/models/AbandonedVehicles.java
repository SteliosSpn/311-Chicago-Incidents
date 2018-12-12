package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "abandoned_vehicles")
public class AbandonedVehicles implements Serializable{
	
	@Id
    private int report_id;
	
	private String license_plate;
	private String vehicle_model;
	private String vehicle_color;
	private String current_activity;
	private String most_recent_action;
	private short how_many_days;
	private short ssa;
	
	
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public String getVehicle_model() {
		return vehicle_model;
	}
	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}
	public String getVehicle_color() {
		return vehicle_color;
	}
	public void setVehicle_color(String vehicle_color) {
		this.vehicle_color = vehicle_color;
	}
	public String getCurrent_activity() {
		return current_activity;
	}
	public void setCurrent_activity(String current_activity) {
		this.current_activity = current_activity;
	}
	public String getMost_recent_action() {
		return most_recent_action;
	}
	public void setMost_recent_action(String most_recent_action) {
		this.most_recent_action = most_recent_action;
	}
	public short getHow_many_days() {
		return how_many_days;
	}
	public void setHow_many_days(short how_many_days) {
		this.how_many_days = how_many_days;
	}
	public short getSsa() {
		return ssa;
	}
	public void setSsa(short ssa) {
		this.ssa = ssa;
	}
	
	
	
}
