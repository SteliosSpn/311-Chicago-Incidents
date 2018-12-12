package com.chicago.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sanitation_code_complaints")
public class SanitationCodeComplaint implements Serializable{

	@Id
    private int report_id;
	
	private String nature_of_violation;

	

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getNature_of_violation() {
		return nature_of_violation;
	}

	public void setNature_of_violation(String nature_of_violation) {
		this.nature_of_violation = nature_of_violation;
	}
	
	
	
}
