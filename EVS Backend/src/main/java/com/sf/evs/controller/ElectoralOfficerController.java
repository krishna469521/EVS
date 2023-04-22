package com.sf.evs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.evs.bean.ApplicationBean;
import com.sf.evs.bean.ElectionBean;
import com.sf.evs.service.ElectoralOfficerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/eo")
public class ElectoralOfficerController {
	@Autowired
	private ElectoralOfficerService EO;
	
	@GetMapping("/viewApplications")
	public List<ApplicationBean> meth1()
	{
		
		return EO.viewApplications();
	}
	
	@PostMapping("/generate")
	public String meth1(@RequestBody String userId, String status) 
	{
		EO. generateVoterId(userId, status);
		return "<h1>voter generate Successfully</h1>";
	}

}
