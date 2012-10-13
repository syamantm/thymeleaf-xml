package com.syamantakm.thymeleaf;

import com.syamantakm.thymeleaf.xml.Model;
import com.syamantakm.thymeleaf.xml.ModelAndView;
import com.syamantakm.thymeleaf.xml.annotation.Controller;
import com.syamantakm.thymeleaf.xml.annotation.Template;

/**
 * @author Syamantak Mukhopadhyay
 */
@Controller
public class UserController {

        @Template(name = "user-primitive")
        public ModelAndView<String> populateUserFromPrimitive(int id, String name) {
            ModelAndView<String> modelAndView = new ModelAndView<String>();
            modelAndView.put("id", id);
            modelAndView.put("name", name);
            return modelAndView;
        }
}
