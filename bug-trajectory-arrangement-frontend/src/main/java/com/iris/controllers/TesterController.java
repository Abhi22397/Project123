package com.iris.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.BugAllocationDetails;
import com.iris.models.BugStatus;
import com.iris.models.BugType;
import com.iris.models.Project;
import com.iris.models.Severity;
import com.iris.models.User;
import com.iris.service.BugAllocationDetailService;
import com.iris.service.BugService;
import com.iris.service.ProjectService;
import com.iris.service.SeverityService;
import com.iris.service.StatusService;

@Controller
public class TesterController {

@Autowired
BugService bugService;
@Autowired
SeverityService severityService;
@Autowired
StatusService statusService;

@Autowired
HttpSession session;

@Autowired
ProjectService projectService;

@Autowired
BugAllocationDetailService bugAllocationDetailService;


 public boolean checkSession(ModelMap map) {
	if(session.getAttribute("userObj")==null) {
	map.addAttribute("msg"," Login First");
	return true;
	}
	return false;
	}
	@RequestMapping(value="/BugAllocated/{projId}",method=RequestMethod.GET)
	public ModelAndView getBugReport(@PathVariable("projId")String projId,@RequestParam(name="msg",required=false)String msg,ModelMap map) {
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
		List<BugType> bugList=bugService.getAllBug();
		List<Severity> sevList=severityService.getAllSeverity();
		List<BugStatus> staList=statusService.getAllStatus();
		System.out.println(bugList);
		System.out.println(sevList);
		System.out.println(staList);
		
		ModelAndView mv=new ModelAndView("BugReport");
	    mv.addObject("bugListObj",bugList);
	    mv.addObject("severityList",sevList);
	    mv.addObject("statusList",staList);
	    session.setAttribute("projectObj",projectService.getProjectById(projId));
	    
	    if(msg!=null) {
	    	mv.addObject("msg",msg);
	    }
	    
	    
	    return mv;
	}
	
	
	@RequestMapping(value="/BugSuccessfullyAllocated",method=RequestMethod.GET)
	public String getBugAllocationDetails(@RequestParam String bug,@RequestParam String severity,@RequestParam String description,ModelMap map)
	{
		if(checkSession(map)) {
			return "Login";
			}
		
		System.out.println("I m here...."+bug+" "+severity+" "+description);
		
		Project pObj=(Project)session.getAttribute("projectObj");
		User uObj=(User)session.getAttribute("userObj");
		BugAllocationDetails bugObj = new BugAllocationDetails();
		bugObj.setUserId(uObj.getId());
		bugObj.setStatusId("B101");
		bugObj.setBugTypeId(bug);
		bugObj.setSeverityId(severity);
		bugObj.setDesc(description);
		bugObj.setProjectId(pObj.getProjId());
		System.out.println(bugObj);
		
		bugAllocationDetailService.saveBugDetails(bugObj);
		return "redirect:BugAllocated/"+pObj.getProjId()+"?msg='Bug Allocated Succesfully...'";
		
	}
}
