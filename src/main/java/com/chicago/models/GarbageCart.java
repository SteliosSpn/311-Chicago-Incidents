package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "garbage_cart")
public class GarbageCart implements Serializable{

	@Id
    private int report_id;
	
	private short number_of_black_carts_delivered;
	private String current_activity;
	private String most_recent_action;
	private short ssa;
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public short getNumber_of_black_carts_delivered() {
		return number_of_black_carts_delivered;
	}
	public void setNumber_of_black_carts_delivered(short number_of_black_carts_delivered) {
		this.number_of_black_carts_delivered = number_of_black_carts_delivered;
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
