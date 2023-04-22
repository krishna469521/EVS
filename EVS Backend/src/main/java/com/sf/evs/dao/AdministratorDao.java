package com.sf.evs.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.evs.bean.ApplicationBean;
import com.sf.evs.bean.CandiateBean;
import com.sf.evs.bean.CredentialsBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.bean.PartyBean;
@Repository
public class AdministratorDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<ElectionBean> q; 
	private Query<PartyBean> r ; 
	private Query<CandiateBean> s;
	private Query<ApplicationBean> t;
	
	public boolean authenticate(CredentialsBean user) 
	{
		System.out.println("Under Dao "+user.getUserID()+" "+user.getPassword());
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q3=session.createQuery("from CredentialsBean where userID=:uid and password=:pss");
		q3.setParameter("uid", user.getUserID());
		q3.setParameter("pss", user.getPassword());
		ArrayList<CredentialsBean> al=(ArrayList<CredentialsBean>) q3.getResultList();
		int count=0;
		for(CredentialsBean cb:al)
		{
			
			if((cb.getUserID().equals(user.getUserID()))&&(cb.getPassword().equals(user.getPassword())))
			{
				System.out.println("Record is  present"+cb.getUserID()+" "+cb.getPassword());
				count++;
				if(count>0)
				{
		return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
		
	}


	public String addElection(ElectionBean electionBean) 
	{
		if(electionBean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(electionBean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(electionBean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public String updateElection(ElectionBean electionBean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(electionBean!=null)
		{
		session.update(electionBean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(electionBean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	public String deleteElection(int electionId)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(electionId>=0)
		{
		Query q1=session.createQuery("delete from ElectionBean where electionID=:eid");
		q1.setParameter("eid", electionId);
		q1.executeUpdate();
transaction.commit();
session.close();
		return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
	}
	public ArrayList<ElectionBean> viewElections()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from ElectionBean");
		return (ArrayList<ElectionBean>) q.list();
	}
	public ElectionBean viewElectionById(int electionId)
	{
		ElectionBean elBean=new ElectionBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<ElectionBean> q2=session.createQuery("from ElectionBean where electionID=:eid");
	q2.setParameter("eid", electionId);
	ArrayList<ElectionBean> all=(ArrayList<ElectionBean>) q2.getResultList();
	for(ElectionBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}

	public String addParty(PartyBean partyBean) 
	{
		if(partyBean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(partyBean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(partyBean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
}
	public ArrayList<PartyBean> viewAllParty()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		r=session.createQuery("from PartyBean");
		return (ArrayList<PartyBean>) r.list();
	}
	public String addCandiate(CandiateBean candiateBean) 
	{
		if(candiateBean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(candiateBean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(candiateBean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}

}
	public ArrayList<CandiateBean> viewCandidateDetailsByElectionName()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		s=session.createQuery("from CandiateBean");
		return (ArrayList<CandiateBean>) s.list();
	}

	public ArrayList<ApplicationBean>viewAllAdminPendingApplications ()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		t=session.createQuery("from ApplicationBean");
		return (ArrayList<ApplicationBean>) t.list();
	}


}

