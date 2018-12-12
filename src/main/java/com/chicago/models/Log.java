package com.chicago.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log implements Serializable{

	@Id
	private Timestamp creation_date;
    private String activity;
    private String email;
    
    public Log() {
    	
    }
    
	public Log(String activity, String email) {
		this.creation_date = new Timestamp(System.currentTimeMillis());
		this.activity = activity;
		this.email = email;
	}
	
	public Timestamp getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
	
}
