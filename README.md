XML Templating with Thymeleaf
=============================

This is a simple MVC framework built with [Spring](http://www.springsource.org/) and [Thymeleaf](http://www.thymeleaf.org/)
template engine to create XML fragments from java objects.


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