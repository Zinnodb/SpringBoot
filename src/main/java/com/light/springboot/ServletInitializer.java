package com.light.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 在web应用层部署
 * @author asus
 *
 */
public class ServletInitializer  extends SpringBootServletInitializer{
			protected  SpringApplicationBuilder configure(SpringApplicationBuilder application) 
			{
				return application.sources(SpringbootApplication.class);
			}
}
