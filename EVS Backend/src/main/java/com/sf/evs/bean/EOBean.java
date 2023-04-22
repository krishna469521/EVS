package com.sf.evs.bean;

import jakarta.persistence.*;

@Entity
@Table(name="EVS_TBL_EO") 
public class EOBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int electoralOfficerID;
	@Column
	private String constituency;
	
	public EOBean() {
		
	}

	
	public int getElectoralOfficerID() {
		return electoralOfficerID;
	}
	public void setElectoralOfficerID(int electoralOfficerID) {
		this.electoralOfficerID = electoralOfficerID;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}


	@Override
	public String toString() {
		return "EOBean [electoralOfficerID=" + electoralOfficerID + ", constituency=" + constituency + "]";
	}
	
	
	

}
