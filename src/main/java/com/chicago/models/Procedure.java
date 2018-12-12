package com.chicago.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedure")
public class Procedure {

	private String request_per_type;
	@Id
    private int total;
    
	public String getRequest_per_type() {
		return request_per_type;
	}
	public void setRequest_per_type(String request_per_type) {
		this.request_per_type = request_per_type;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
    
    
	
}
