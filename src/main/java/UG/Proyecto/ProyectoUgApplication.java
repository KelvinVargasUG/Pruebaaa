package UG.Proyecto;

import org.ocpsoft.rewrite.servlet.RewriteFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

import com.sun.*;
import javax.faces.webapp.FacesServlet;


@EnableAutoConfiguration
@ComponentScan({"com.auth0.samples.bootfaces"})

public class ProyectoUgApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoUgApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
	ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
	registration.setLoadOnStartup(1);
//	registration.addUrlMappings("*.jr");
	return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
	return servletContext -> {
	    servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	    servletContext.setInitParameter("primefaces.THEME", "sunny");
	};
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
	return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate();
    }

    

}
