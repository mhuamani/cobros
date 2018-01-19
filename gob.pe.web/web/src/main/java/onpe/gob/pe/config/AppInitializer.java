/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onpe.gob.pe.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author MHuamani
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        //String loggerPath = "WEB-INF/classes/log4j.properties";
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(sc);
        //sc.getServletContext().setInitParameter(Log4jWebSupport.LOG4J_CONFIG_LOCATION, loggerPath);
        //sc.setInitParameter("log4jConfigLocation", loggerPath);        
        
        //String log4jConfigFile = sc.getInitParameter("WEB-INF/log4j.properties");
        //String fullPath = sc.getRealPath("") + File.separator + log4jConfigFile;
        //PropertyConfigurator.configure(fullPath);
        ServletRegistration.Dynamic servlet = sc.addServlet("dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
}
