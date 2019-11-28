package com.iris.controllers;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
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
import com.iris.models.User;
import com.iris.service.BugAllocationDetailService;
import com.iris.service.StatusService;
import com.iris.service.UserService;

@Controller
public class DeveloperController {

@Autowired
BugAllocationDetailService bugAllocationDetailService;
@Autowired
UserService userService;
@Autowired
HttpSession session;
@Autowired
StatusService statusService;

public boolean checkSession(ModelMap map) {
	if(session.getAttribute("userObj")==null) {
	       map.addAttribute("msg"," Login First");
	        return true;
}
	     return false;
 	}
    @RequestMapping(value="/assigned",method=RequestMethod.POST)
    public ModelAndView getAssignedBug(ModelMap map)
      {
	       if(checkSession(map)) {
		    return new ModelAndView("Login");
		}

	      User uObj=(User) session.getAttribute("userObj");
	      int id=uObj.getId();
     	  List<BugAllocationDetails> bugAllocationList=bugAllocationDetailService.getAllBugDesc();
	      List<BugAllocationDetails> bugAlloList=bugAllocationDetailService.getBugDesc(id);
	      ModelAndView  mv=new ModelAndView("AssignedBugToDeveloper");
   	     mv.addObject("AssignedBugDetail", bugAlloList);
	     return mv;
  }
     @RequestMapping(value="/updateStatus/{bugAllocateId}",method=RequestMethod.GET)
        public ModelAndView fixBug(@PathVariable("bugAllocateId")int bugAllocateId,ModelMap map) {
  	       if(checkSession(map)) {
  		    return new ModelAndView("Login");
  		}
	      BugAllocationDetails bugAssign=bugAllocationDetailService.getBugAllocationById(bugAllocateId);
	      List<BugStatus> staList=statusService.getAllStatus();
	      System.out.println("List of bug assigned to developer"+bugAssign);
	      ModelAndView mv=new ModelAndView("BugFix");
	      mv.addObject("bugDetail",bugAssign);
	      mv.addObject("statusList",staList);
          return mv;
     }
    @RequestMapping(value="/fixbug",method=RequestMethod.GET)
   public ModelAndView bugAssigned(@RequestParam int bugAllocateId,@RequestParam String projectId,@RequestParam String status,@RequestParam("actualAssignedDate") @DateTimeFormat(pattern="yyyy-MM-dd")  Date actualAssignedDate,@RequestParam("actualEndDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date actualEndDate,ModelMap map)
   { 

	if(checkSession(map)) {
		return new ModelAndView("Login");
		}
	BugAllocationDetails bugAssign=bugAllocationDetailService.getBugAllocationById(bugAllocateId);
	bugAssign.setProjectId(projectId);
	bugAssign.setStatusId(status);
	bugAssign.setActualStartDate(actualAssignedDate);
	bugAssign.setActualEndDate(actualEndDate);
	bugAllocationDetailService.update(bugAssign);
	
	User uObj=(User) session.getAttribute("userObj");
    int id=uObj.getId();
     List<BugAllocationDetails> bugAllocationList=bugAllocationDetailService.getAllBugDesc();
    List<BugAllocationDetails> bugAlloList=bugAllocationDetailService.getBugDesc(id);
     ModelAndView  mv=new ModelAndView("AssignedBugToDeveloper");
     mv.addObject("AssignedBugDetail", bugAlloList);
     return mv;
	//return new  ModelAndView("AssignedBugToDeveloper");
   }
}
