package br.com.sempreufg.service.configuration;

import javax.servlet.annotation.WebFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.sempreufg.service.interceptor.AuthenticationInterceptor;

@EnableWebMvc
@Configuration
@WebFilter
public class ConfigurationService extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthenticationInterceptor());
	}
}
