package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "robent_baiting")
public class RobentBaiting implements Serializable{

	@Id
    private int report_id;
	
	private short premises_baited;
	private short premises_with_garbage;
	private short premises_with_rats;
	private String current_activity;
	private String most_recent_action;
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public short getPremises_baited() {
		return premises_baited;
	}
	public void setPremises_baited(short premises_baited) {
		this.premises_baited = premises_baited;
	}
	public short getPremises_with_garbage() {
		return premises_with_garbage;
	}
	public void setPremises_with_garbage(short premises_with_garbage) {
		this.premises_with_garbage = premises_with_garbage;
	}
	public short getPremises_with_rats() {
		return premises_with_rats;
	}
	public void setPremises_with_rats(short premises_with_rats) {
		this.premises_with_rats = premises_with_rats;
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
