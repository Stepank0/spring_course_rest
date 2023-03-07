package com.zaurtregulov.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
создаем настройку как web.xml + проверить наличие war.plugin
 */

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() { // создаем ссылку на DispatcherServlet
        return new Class[] {MyConfig.class};
        /*
    <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     <init-param>
       <param-name>contextConfigLocation</param-name>
       <param-value>/WEB-INF/applicationContext.xml</param-value>
     </init-param>
    <load-on-startup>1</load-on-startup>
    </servlet>
         */
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
                /*
    <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
    </servlet-mapping>
                 */
    }



}
