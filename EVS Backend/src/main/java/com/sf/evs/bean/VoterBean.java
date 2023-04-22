package com.sf.evs.bean;

import jakarta.persistence.*;
@Entity
@Table(name="EVS_TBL_VOTER_DEATAILS")	
public class VoterBean {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int serialNo;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "electionID", referencedColumnName = "electionID")
private ElectionBean electionBean;
	
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "candiateID", referencedColumnName = "candiateID")
private CandiateBean candiateBean;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "voterID", referencedColumnName = "voterID")
private ApplicationBean applicationBean;

public int getSerialNo() {
	return serialNo;
}

public void setSerialNo(int serialNo) {
	this.serialNo = serialNo;
}

public ElectionBean getElectionBean() {
	return electionBean;
}

public void setElectionBean(ElectionBean electionBean) {
	this.electionBean = electionBean;
}

public CandiateBean getCandiateBean() {
	return candiateBean;
}

public void setCandiateBean(CandiateBean candiateBean) {
	this.candiateBean = candiateBean;
}

public ApplicationBean getApplicationBean() {
	return applicationBean;
}

public void setApplicationBean(ApplicationBean applicationBean) {
	this.applicationBean = applicationBean;
}


}
