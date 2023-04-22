
package com.sf.evs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.evs.bean.ApplicationBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.dao.ElectoralOfficerDao;

@Service
public class ElectoralOfficerService {
@Autowired
private ElectoralOfficerDao edao;

public ArrayList<ApplicationBean>viewApplications()
{
	return edao.viewApplications();
}
public String generateVoterId(String userId, String status) 
{
	return edao. generateVoterId  (userId,status);
}


}
