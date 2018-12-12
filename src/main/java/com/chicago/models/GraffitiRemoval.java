package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "graffiti_removal")
public class GraffitiRemoval implements Serializable{

	@Id
    private int report_id;
	
	private String surface;
	private String graffiti_location;
	private short ssa;
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getGraffiti_location() {
		return graffiti_location;
	}
	public void setGraffiti_location(String graffiti_location) {
		this.graffiti_location = graffiti_location;
	}
	public short getSsa() {
		return ssa;
	}
	public void setSsa(short ssa) {
		this.ssa = ssa;
	}
	
	
	
}
