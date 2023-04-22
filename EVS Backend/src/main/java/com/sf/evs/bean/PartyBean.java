package com.sf.evs.bean;

import jakarta.persistence.*;
@Entity
@Table(name="EVS_TBL_PARTY")
public class PartyBean {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column

private int partyID;
@Column
private String  name;
@Column
private String leader;
@Column
private String symbol;
public int getPartyID() {
	return partyID;
}
public void setPartyID(int partyID) {
	this.partyID = partyID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLeader() {
	return leader;
}
public void setLeader(String leader) {
	this.leader = leader;
}
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}

}
