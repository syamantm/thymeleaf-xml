package com.syamantakm.thymeleaf.xml.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Syamantak Mukhopadhyay
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component // this annotation makes Spring recognize @Facade
public @interface Controller {
}
