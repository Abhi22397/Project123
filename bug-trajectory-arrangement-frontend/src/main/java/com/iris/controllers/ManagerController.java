package com.iris.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.BugAllocationDetails;
import com.iris.models.BugStatus;
import com.iris.models.Project;
import com.iris.models.User;
import com.iris.service.BugAllocationDetailService;
import com.iris.service.ProjectService;
import com.iris.service.StatusService;
import com.iris.service.UserService;

@Controller
public class ManagerController {
    @Autowired
    UserService userService;
    
	@Autowired
	ProjectService projectService;
	
    @Autowired
    StatusService statusService;

	@Autowired
	HttpSession session;
	
	@Autowired
	BugAllocationDetailService bugAllocationDetailService;

	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("userObj")==null) {
		map.addAttribute("msg"," Login First");
		return true;
		}
		return false;
		}

	@RequestMapping(value="/projectAllocated",method=RequestMethod.POST)
	public ModelAndView getProjectAllocation(@RequestParam String project,@RequestParam int[] developer,@RequestParam int[] tester,ModelMap map) {
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}

		Project pObj=projectService.getProjectById(project);
	
		List<User> usersList=pObj.getUsers();
		
		for(int i:developer) {
			
			User uObj=userService.getUserById(i);

			uObj.getProjects().add(pObj);
			
			usersList.add(uObj);
			}
		
		for(int i:tester) {
			User uObj=userService.getUserById(i);
			uObj.getProjects().add(pObj);
			usersList.add(uObj);
		}
		
		pObj.setUsers(usersList);
		
		
		System.out.println(pObj);
		try {
		projectService.updateProject(pObj);
		map.addAttribute("message","Project Allocated");
		}
		catch (Exception e) {
            map.addAttribute("message","Project has  already been allocated");
		}
		System.out.println("Project Obj : "+pObj);
		
		List<Project> proList=projectService.getAllProjects();
	    List<User> dList=userService.getAllDeveloper();
	    List<User> tList=userService.getAllTester();
		ModelAndView mv=new ModelAndView("ProjectAllocationForm");
	     mv.addObject("projectList",proList);
	     mv.addObject("developerList",dList);
	     mv.addObject("testerList",tList);
	     
	     System.out.println(proList+""+dList+""+tList);
	     return mv;
		
	}
	
	@RequestMapping(value="/ViewBugDetail",method=RequestMethod.GET)
	public ModelAndView getBugDetails(ModelMap map)
	{
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
		List<BugAllocationDetails> bugAllocationList=bugAllocationDetailService.getAllBugDesc();
		System.out.println(bugAllocationList);
		ModelAndView mv=new ModelAndView("ViewBugDetail");
		mv.addObject("bugAllocatedList",bugAllocationList);
		 session.setAttribute("bugAllocate",bugAllocationList);
		return mv;
	}
	
	
	@RequestMapping(value="/showBugDetail/{bugAllocateId}",method=RequestMethod.GET)
	public ModelAndView assignBug(@PathVariable("bugAllocateId")int bugAllocateId,ModelMap map)
	{ 
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
		BugAllocationDetails bugAllocDet=bugAllocationDetailService.getBugAllocationById(bugAllocateId);
		List<BugStatus> staList=statusService.getAllStatus();
		
		Project pObj=projectService.getProjectById(bugAllocDet.getProjectId());
		List<User> usersList=pObj.getUsers();
		List<User> developersList=new ArrayList<>();
		
		for(User userObj:usersList) {
			if(userObj.getDesg().equals("Developer")) {
				developersList.add(userObj);
			}
			
		}
		
		System.out.println("UserList Corresponding to that project "+usersList);
		System.out.println(bugAllocDet);
		System.out.println(staList);
		ModelAndView mv=new ModelAndView("AssignBug");
		mv.addObject("bugAlloactionDetails",bugAllocDet);
		mv.addObject("statusList",staList);
		mv.addObject("uList",developersList);
		return mv;
	}
	
	@RequestMapping(value="/assigned",method=RequestMethod.GET)
	public ModelAndView bugAssigned(@RequestParam int bugAllocateId,@RequestParam int developer,@RequestParam String projectId,@RequestParam String status,@RequestParam("assignedDate") @DateTimeFormat(pattern="yyyy-MM-dd")  Date assignedDate,@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,ModelMap map)
	{ 

		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
		BugAllocationDetails bugAssign=bugAllocationDetailService.getBugAllocationById(bugAllocateId);
		bugAssign.setProjectId(projectId);
		bugAssign.setStatusId(status);
		bugAssign.setPlannedStartdate(assignedDate);
		bugAssign.setPlannedEndDate(endDate);
		bugAssign.setUserId(developer);
		bugAllocationDetailService.update(bugAssign);
	    List<BugAllocationDetails> bugAllocationList=bugAllocationDetailService.getAllBugDesc();
		System.out.println(bugAllocationList);
        ModelAndView mv=new ModelAndView("ViewBugDetail");
		mv.addObject("bugAllocatedList",bugAllocationList);
		return mv;
		
	}

}
