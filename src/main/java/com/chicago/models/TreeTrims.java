package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tree_trims")
public class TreeTrims implements Serializable{

	@Id
    private int report_id;
	
	private String tree_location;

	

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getTree_location() {
		return tree_location;
	}

	public void setTree_location(String tree_location) {
		this.tree_location = tree_location;
	}
	
	
	
}
