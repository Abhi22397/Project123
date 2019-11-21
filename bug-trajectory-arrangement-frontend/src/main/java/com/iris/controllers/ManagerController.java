package com.iris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.Project;
import com.iris.models.User;
import com.iris.service.ProjectService;
import com.iris.service.UserService;

@Controller
public class ManagerController {
    @Autowired
    UserService userService;
    
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/projectAllocation",method=RequestMethod.POST)
	public String getProjectAllocation() {
		return "ProjectAllocationForm";
	}
	
//	@RequestMapping(value="/projectAllocated",method=RequestMethod.POST)
//	public ModelAndView geAllProjects(){
//     List<Project> proList=projectService.getAllProjects();
//     ModelAndView mv=new ModelAndView("ProjectAllocationForm");
//     mv.addObject("projectList",proList);
//	return mv;
//     }
//	@RequestMapping(value="/projectAllocated",method=RequestMethod.POST)
//	public ModelAndView geAllUser(String desg){
//     List<User> uList=userService.getAllUserByDesg(desg);
//     ModelAndView mv=new ModelAndView("ProjectAllocationForm");
//     mv.addObject("userList",uList);
//	 return mv;
//     }
}
