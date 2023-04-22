package com.sf.evs.bean;

import jakarta.persistence.*;
@Entity
@Table(name="EVS_TBL_RESULT")
public class ResultBean {
@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int serialNo;

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
@JoinColumn(name = "candiateID", referencedColumnName = "candiateID")
private CandiateBean candiateBean;

public CandiateBean getCandiateBean() {
	return candiateBean;
}

public void setCandiateBean(CandiateBean candiateBean) {
	this.candiateBean = candiateBean;
}
@Column 
private int voteCount;

public int getSerialNo() {
	return serialNo;
}

public void setSerialNo(int serialNo) {
	this.serialNo = serialNo;
}

public int getVoteCount() {
	return voteCount;
}

public void setVoteCount(int voteCount) {
	this.voteCount = voteCount;
}
	
	
}
