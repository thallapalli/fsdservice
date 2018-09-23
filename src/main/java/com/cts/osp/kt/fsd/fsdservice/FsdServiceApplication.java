package com.cts.osp.kt.fsd.fsdservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FsdServiceApplication extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FsdServiceApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(FsdServiceApplication.class, args);
	}
}
