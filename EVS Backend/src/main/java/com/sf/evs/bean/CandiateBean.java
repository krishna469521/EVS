package com.sf.evs.bean;

import jakarta.persistence.*;

@Entity
@Table(name="EVS_TBL_CANDIATE")
public class CandiateBean {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int candiateID;
@Column
private String name;
	

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "electionID", referencedColumnName = "electionID")
private ElectionBean electionBean;

public ElectionBean getElectionBean() {
	return electionBean;
}
public void setElectionBean(ElectionBean electionBean) {
	this.electionBean = electionBean;
}
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "partyID", referencedColumnName = "partyID")
private PartyBean partyBean;

public PartyBean getPartyBean() {
	return partyBean;
}
public void setPartyBean(PartyBean partyBean) {
	this.partyBean = partyBean;
}

@Column
private  String district;
@Column
private String constituency;
@Column
private String dateOfBirth;
@Column
private String mobileNo;
@Column
private String address;
@Column
private String emailID;
public int getCandiateID() {
	return candiateID;
}
public void setCandiateID(int candiateID) {
	this.candiateID = candiateID;
}


public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
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
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmailID() {
	return emailID;
}
public void setEmailID(String emailID) {
	this.emailID = emailID;
}

}
