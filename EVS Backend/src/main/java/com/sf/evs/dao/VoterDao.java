package com.sf.evs.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.evs.bean.CandiateBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.bean.ResultBean;
import com.sf.evs.service.AdministratorService;

@Repository
public class VoterDao  {
@Autowired

private SessionFactory sessionFactory;
private Session session;
private Transaction transaction;
private Query<CandiateBean> q; 
private Query<ResultBean> s; 
private Query<ElectionBean> r; 


@Autowired
private AdministratorDao adao;


public ArrayList<ResultBean> viewListOfElectionsResults()
{
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	s=session.createQuery("from ResultBean");
	return (ArrayList<ResultBean>) s.list();
}
public ArrayList<ElectionBean>viewListOfElections()
{
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	r=session.createQuery("from ElectionBean");
	return (ArrayList<ElectionBean>) r.list();
}






public ArrayList<CandiateBean> 
viewCandidatesByElectionName(String name, String constituency,int electionID) 
{
	System.out.println("under Candidate dao "+electionID);
	ElectionBean eb=adao.viewElectionById(electionID);
	System.out.println(eb);
	if((eb.getName().equals(name)) && (eb.getConstituency().equals( constituency)))
	{
	CandiateBean cBean=new CandiateBean();
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
Query<CandiateBean> q2=session.createQuery("from CandiateBean");
System.out.println((ArrayList<CandiateBean>) q2.getResultList());
 return (ArrayList<CandiateBean>) q2.getResultList();
}
	System.out.println("hi");
	return null;
}

}







