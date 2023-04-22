package com.sf.evs.bean;

import jakarta.persistence.*;
@Entity
@Table(name="EVS_TBL_CREDENTIALS")
public class CredentialsBean {
@Id

@Column(name = "Userid", length = 6)
private String userID;
@Column(name = "Password", length = 20, nullable = false)
private  String password;
@Column(name = "Usertype", length = 1, nullable = false)
private String userType;
@Column(name = "Loginstatus")
private int loginStatus;


public String  getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public int getLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(int loginStatus) {
	this.loginStatus = loginStatus;
}


}
