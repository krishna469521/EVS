
package com.sf.evs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.evs.bean.CandiateBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.bean.ResultBean;
import com.sf.evs.service.VoterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/voter")
public class VoterController {
	@Autowired
	private VoterService voserv;
	
	@GetMapping("/select/{name}/{constituency}/{id}")
	public ArrayList<CandiateBean> meth7(@PathVariable(value = "name") String name, @PathVariable(value = "constituency") String constituency , @PathVariable(value = "id") int electionID)
	{
		System.out.println("under controller "+electionID);
		return voserv.viewCandidatesByElectionName(name, constituency, electionID);
		
	}
	@GetMapping("/result")
	public List<ResultBean> meth3()
	{		
		return voserv.viewListOfElectionsResults();
	}

	@GetMapping("/listofelections")
	public ArrayList<ElectionBean> meth4()
	{		
		return voserv.viewListOfElections();

	}



}
