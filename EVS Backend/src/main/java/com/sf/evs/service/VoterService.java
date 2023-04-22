package com.sf.evs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.evs.bean.CandiateBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.bean.PartyBean;
import com.sf.evs.bean.ResultBean;
import com.sf.evs.dao.VoterDao;

@Service
public class VoterService {
@Autowired
private VoterDao vdao;


public ArrayList<CandiateBean> 
viewCandidatesByElectionName(String name, String constituency,int electionID) {
	return vdao.viewCandidatesByElectionName(name, constituency, electionID);
}
public ArrayList<ResultBean>viewListOfElectionsResults()
{
	return vdao.viewListOfElectionsResults();
}

public ArrayList<ElectionBean>viewListOfElections()
{
	return vdao.viewListOfElections();
}




}
