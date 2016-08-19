package com.atliwen;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.atliwen.server.AccessFilter;

@EnableZuulProxy
@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter()
	{
		return new AccessFilter();
	}

}
