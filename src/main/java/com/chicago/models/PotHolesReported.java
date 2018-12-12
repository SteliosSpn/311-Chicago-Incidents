package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pot_holes_reported")
public class PotHolesReported implements Serializable{

	@Id
    private int report_id;
	
	private short potholes_filled;
	private String current_activity;
	private String most_recent_action;
	private short ssa;
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public short getPotholes_filled() {
		return potholes_filled;
	}
	public void setPotholes_filled(short potholes_filled) {
		this.potholes_filled = potholes_filled;
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
	public short getSsa() {
		return ssa;
	}
	public void setSsa(short ssa) {
		this.ssa = ssa;
	}
	
	
	
}
