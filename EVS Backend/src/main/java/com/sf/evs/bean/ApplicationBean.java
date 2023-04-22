

package com.sf.evs.bean;

import jakarta.persistence.*;
@Entity
@Table(name="EVS_TBL_APPLICATION")
public class ApplicationBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	
	private int voterID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userID", referencedColumnName = "userID")
private CredentialsBean credentialsBean;
	
public CredentialsBean getCredentialsBean() {
		return credentialsBean;
	}
	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}
	@Column
	private String constituency;

	@Column
	private int passedStatus;
	@Column
	private int approvedStatus;
	
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getPassedStatus() {
		return passedStatus;
	}
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}
	public int getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	public int getVoterID() {
		return voterID;
	}
	public void setVoterID(int voterID) {
		this.voterID = voterID;
	}
	
	

}
