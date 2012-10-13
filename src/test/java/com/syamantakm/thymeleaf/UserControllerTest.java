package com.syamantakm.thymeleaf;

import com.syamantakm.thymeleaf.UserController;
import com.syamantakm.thymeleaf.xml.Model;
import com.syamantakm.thymeleaf.xml.ModelAndView;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Syamantak Mukhopadhyay
 */
public class UserControllerTest {


    private UserController userController;

    @Before
    public void setUp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("thymeleaf-test-spring-context.xml");
        context.refresh();
        userController  = (UserController) context.getBean("userController");
    }

    @Test
    public void shouldGenerateXmlWithPrimitiveValues(){
        //Given
        int id = 12;
        String name = "Test Name" ;

        String expectedXml = "<?xml version=\"1.0\"?>\n" +
                "<user>\n" +
                "    <userid>12</userid>\n" +
                "    <username>Test Name</username>\n" +
                "</user>";

        //When
        ModelAndView modelAndView = userController.populateUserFromPrimitive(id, name);

        //Then
        assertTrue(modelAndView instanceof  ModelAndView);
        assertEquals(id, modelAndView.getFields().get("id"));
        assertEquals(name, modelAndView.getFields().get("name"));

        assertTrue(modelAndView.getView().equals(expectedXml));
    }
}
