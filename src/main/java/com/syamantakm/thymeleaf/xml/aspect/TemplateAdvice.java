package com.syamantakm.thymeleaf.xml.aspect;

import com.syamantakm.thymeleaf.xml.ModelAndView;
import com.syamantakm.thymeleaf.xml.annotation.Template;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

/**
 * @author Syamantak Mukhopadhyay
 */
@Aspect
public class TemplateAdvice {

    private static final Logger LOGGER = Logger.getLogger(TemplateAdvice.class);

    @Autowired
    private TemplateEngine templateEngine;

    public TemplateAdvice() {
        LOGGER.info("TemplateAdvice created");
    }

    @Around("@target(com.syamantakm.thymeleaf.xml.annotation.Controller) " +
            "&& @annotation(template)")
    public Object doTransform(ProceedingJoinPoint pjp, Template template) throws Throwable {
        String result = null;
       /* Method method = pjp.getSignature().getDeclaringType().getDeclaredMethod(pjp.getSignature().getName(), method.getParameterTypes());
        Template template = method.getAnnotation(Template.class);*/
        String templateName = template.name();
        Object retVal = pjp.proceed();
        if(templateName != null && retVal instanceof ModelAndView) {
            ModelAndView modelAndView = (ModelAndView)retVal;
            final Context ctx = new Context();
            for(Map.Entry<String, Object> entry : modelAndView.getFields().entrySet()) {
                ctx.setVariable(entry.getKey(), entry.getValue());
            }
            result = templateEngine.process(templateName, ctx);
            LOGGER.info("Result : \n" + result);
            modelAndView.apply(result);
        }

        return retVal;
    }

}
