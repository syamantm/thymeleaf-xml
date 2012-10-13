XML Templating with Thymeleaf
=============================

This is a simple MVC framework built with [Spring](http://www.springsource.org/) and [Thymeleaf](http://www.thymeleaf.org/)
template engine to create XML fragments from java objects for non-web based applications.


Dependencies
------------

[Spring Framework 3.1](http://www.springsource.org/)

[Thymeleaf](http://www.thymeleaf.org/)


Getting Started
---------------

### XML Template

Create a xml template named user-primitive.xml:

    <?xml version="1.0" encoding="UTF-8" ?>
    <user>
        <userid th:text="${id}">user id</userid>
        <username th:text="${name}">username</username>
    </user>

### Controller

Create a controller class by annotating with `@Controller(com.syamantakm.thymeleaf.xml.annotation.Controller)`

    @Controller
    public class UserController {

    }

### Model and View

Inside the controller define a controller action to apply a template/view to a model. In order to do that simply create
a `ModelAndView` object and populate all the required fields/variables used in the view/template. Then annotate the action
with `@Template(com.syamantakm.thymeleaf.xml.annotation.Template)` and pass the template name to the annotation.

    @Template(name = "user-primitive")
    public ModelAndView<String> populateUserFromPrimitive(int id, String name) {
        ModelAndView<String> modelAndView = new ModelAndView<String>();
        modelAndView.put("id", 12);
        modelAndView.put("name", "Test Name");
        return modelAndView;
    }

The finished Controller would look like:

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

### Output

The final xml output would look like

    <?xml version="1.0"?>
    <user>
        <userid>12</userid>
        <username>Test Name</username>
    </user>

This output can be accessed by calling `getView()` on the `ModelAndView` object, returned by the controller action.

