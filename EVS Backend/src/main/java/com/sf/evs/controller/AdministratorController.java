package com.sf.evs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sf.evs.bean.ApplicationBean;
import com.sf.evs.bean.CandiateBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.bean.PartyBean;
import com.sf.evs.bean.CredentialsBean;
import com.sf.evs.service.AdministratorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/admin")
public class AdministratorController {
	@Autowired
	private AdministratorService adserv;
	
	@GetMapping("/selectUser/{userID}/{password}")
	@ResponseBody
	public boolean auth(@PathVariable String userID,@PathVariable String password)
{
	//CredentialsBean cb=new CredentialsBean();
	//cb.setUserID(userID);	cb.setPassword(password);
		//System.out.println("Under Controller "+userID+" "+password);
		//String str = Integer.toString(cb.setUserID());
		CredentialsBean cb=new CredentialsBean();
		cb.setUserID(userID);
		cb.setPassword(password);
		System.out.println(adserv.authenticate(cb));;
		return adserv.authenticate(cb);
	}
@PostMapping("/addElection")
public String meth1(@RequestBody ElectionBean eb)
{
	adserv.addElection(eb);
	return "<h1>Election Added Successfully</h1>";
}
@GetMapping("/selectAll")
public List<ElectionBean> meth2()
{
	
	return adserv.viewElections();
}

@PutMapping("/updateElection")
public String meth3(@RequestBody ElectionBean eb)
{
	adserv.updateElection(eb);
	return "<h1> Election Updated successfully</h1>";
}
@GetMapping("/election/{id}")
public ElectionBean meth4(@PathVariable(value = "id") int electionId)
{
	return adserv.viewElectionById(electionId);
	
}
@DeleteMapping("/electionID/{id}")
public String meth5(@PathVariable(value="id") int electionId)
{
	return "<h1>"+adserv.deleteElection(electionId)+" record deleted successfully</h1>";
}

@PostMapping("/addParty")
public String meth6(@RequestBody PartyBean ec)
{
	adserv.addParty(ec);
	return "<h1>Party Added Successfully</h1>";
}
@GetMapping("/viewAllParty")
public List<PartyBean> meth7()
{
	
	return adserv.viewAllParty();
}

@PostMapping("/addcandiate")
public String meth8(@RequestBody CandiateBean ed)
{
	adserv.addCandiate(ed);
	return "<h1>Candiate  Added Successfully</h1>";
}
@GetMapping("/viewAllCandiate")
public List<CandiateBean> meth9()
{	
	return adserv.viewCandidateDetailsByElectionName();
}
@GetMapping("/viewAllPendingApplications")
public List<ApplicationBean> meth10()
{
	
	return adserv.viewAllAdminPendingApplications();
}


}