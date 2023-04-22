package com.sf.evs.bean;

import jakarta.persistence.*;

@Entity
@Table(name="EVS_TBL_ELECTION")
public class ElectionBean
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
private int electionID;
	@Column
private String name;
	@Column
private String electionDate;
	@Column
private String district;
	@Column
private String constituency; 
private String countingDate;	
public int getElectionID() {
	return electionID;
}
public void setElectionID(int electionID) {
	this.electionID = electionID;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getElectionDate() {
	return electionDate;
}
public void setElectionDate(String electionDate) {
	this.electionDate = electionDate;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getConstituency() {
	return constituency;
}
public void setConstituency(String constituency) {
	this.constituency = constituency;
}
public String getCountingDate() {
	return countingDate;
}
public void setCountingDate(String countingDate) {
	this.countingDate = countingDate;
}
@Override
public String toString() {
	return "ElectionBean [electionID=" + electionID + ", name=" + name + ", electionDate=" + electionDate
			+ ", district=" + district + ", constituency=" + constituency + ", countingDate=" + countingDate + "]";
}



}