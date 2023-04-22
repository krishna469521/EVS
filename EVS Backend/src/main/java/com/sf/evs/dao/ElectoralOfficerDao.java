package com.sf.evs.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.evs.bean.ApplicationBean;
import com.sf.evs.bean.ElectionBean;

@Repository
public class ElectoralOfficerDao {
private static final String applicationBean = null;
@Autowired

private SessionFactory sessionFactory;
private Session session;
private Transaction transaction;
private Query<ApplicationBean> q;


public ArrayList<ApplicationBean> viewApplications()
{
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	q=session.createQuery("from ApplicationBean");
	return (ArrayList<ApplicationBean>) q.list();
}
public  String generateVoterId(String userId, String status) 
{
	if(applicationBean!=null)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(applicationBean);
		transaction.commit();
		session.close();
		return "SUCCESS";
	}
	else if(applicationBean==null)
	{
		return "ERROR";
	}
	else
	{
		return "FAIL";
	}
}


}
