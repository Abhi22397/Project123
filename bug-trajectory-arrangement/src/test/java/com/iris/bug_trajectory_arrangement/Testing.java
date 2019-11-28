package com.iris.bug_trajectory_arrangement;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DBConfig;
import com.iris.models.Project;
import com.iris.models.User;
import com.iris.service.ProjectService;
import com.iris.service.UserService;

public class Testing {
    private static UserService userService;
    private static ProjectService projectService;

	@BeforeClass
    public static void init() {
                    System.out.println("Before Init");
                    try {
                    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
                    userService=context.getBean("userServiceObj",UserService.class);
                    }
                    catch(Exception e) {
                                    e.printStackTrace();
                    }
                    System.out.println("After Init");
    }
    
    @Test 
   @Ignore
    public void validateTest() {
                    User obj=userService.validateUser("krish@gmail.com", "k@1234");
                    System.out.println(obj);
                    assertNotNull("User Doesnt found", obj);
    }
    @Test
@Ignore
	public void getAllProject() {
		List<Project> p=projectService.getAllProjects();
		Assert.assertNotEquals("NO PRODUCT IN THE LIST", p.size(),0);
}

}
