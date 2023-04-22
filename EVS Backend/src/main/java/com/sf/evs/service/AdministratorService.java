
package com.sf.evs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.evs.bean.ApplicationBean;
import com.sf.evs.bean.CandiateBean;
import com.sf.evs.bean.CredentialsBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.bean.PartyBean;
import com.sf.evs.dao.AdministratorDao;

@Service
public class AdministratorService {
@Autowired
private AdministratorDao adao;

public boolean authenticate(CredentialsBean user) 
{
return  adao.authenticate(user);
}


public String addElection(ElectionBean electionBean) 
{
	return adao.addElection(electionBean);
}
public ArrayList<ElectionBean> viewElections()
{
	return adao.viewElections();
}
public String updateElection(ElectionBean electionBean)
{
	return adao.updateElection(electionBean);
}
public String deleteElection(int electionId)
{
	return adao.deleteElection(electionId);
}
public ElectionBean viewElectionById(int electionId)
{
	return adao.viewElectionById(electionId);
}
public String addParty(PartyBean partyBean) 
{
	return adao.addParty(partyBean);
}
public ArrayList<PartyBean> viewAllParty()
{
	return adao.viewAllParty();
}
public String addCandiate(CandiateBean candiateBean) 
{
	return adao.addCandiate(candiateBean);
}
public ArrayList<CandiateBean>viewCandidateDetailsByElectionName()
{
	return adao.viewCandidateDetailsByElectionName();
}
public ArrayList<ApplicationBean>viewAllAdminPendingApplications()
{
	return adao.viewAllAdminPendingApplications();
}

}