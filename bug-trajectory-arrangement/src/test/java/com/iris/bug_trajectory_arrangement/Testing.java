package com.iris.bug_trajectory_arrangement;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DBConfig;
import com.iris.models.User;
import com.iris.service.UserService;

public class Testing {
    private static UserService userService;

	@BeforeClass
    public static void init() {
                    System.out.println("BEfore Init");
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
   
    public void validateTest() {
                    User obj=userService.validateUser(2, "k@1234");
                    System.out.println(obj);
                    assertNotNull("User Doesnt found", obj);
    }

}
