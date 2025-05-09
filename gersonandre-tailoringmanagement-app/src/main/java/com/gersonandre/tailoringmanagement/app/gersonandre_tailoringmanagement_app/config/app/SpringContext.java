package com.gersonandre.tailoringmanagement.app.gersonandre_tailoringmanagement_app.config.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContext.context = applicationContext;
    }

    /**
     * Devuelve el bean del tipo dado.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> beanClass) {
        return (T) context.getBean(beanClass);
    }
}
