package br.com.sportsgo.service.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class InitService implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		WebApplicationContext context = getContext();
		
		servletContext.addListener(new ContextLoaderListener(context));
		servletContext.addServlet("SpringDispatcher", new DispatcherServlet(getAppContext()));
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",
				new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/services/*");
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("br.com.sportsgo");
		return context;
	}
	
	private AnnotationConfigWebApplicationContext getAppContext() {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);
		return appContext;
	}

}