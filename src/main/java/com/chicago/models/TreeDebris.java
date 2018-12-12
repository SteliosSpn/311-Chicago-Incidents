package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tree_debris")
public class TreeDebris implements Serializable{

	@Id
    private int report_id;
	
	private String debris_location;
	private String current_activity;
	private String most_recent_action;
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public String getDebris_location() {
		return debris_location;
	}
	public void setDebris_location(String debris_location) {
		this.debris_location = debris_location;
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
	
	
}
