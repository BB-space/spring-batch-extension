package com.guesthouse.spring.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;


@Configuration
@ComponentScan(basePackages = "com.guesthouse", excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class AppConfig {
	
	protected static Logger log = LoggerFactory.getLogger(AppConfig.class);
	
	public AppConfig() {
		StringBuffer sbf = new StringBuffer();

		sbf.append("                               _                      _                _             _     			\n");
		sbf.append("                              (_)                    | |              | |          | |    			\n");
		sbf.append("        ___  _ __   _ __  _  _ __    __ _   | |__    __ _ | |_   ___ | |__  			\n");
		sbf.append("       / __|| '_  \\ | '__|| || '_ \\  /  _` |  | '_  \\ /  _` ||  __|/ __|| '_  \\ 	\n");
		sbf.append("       \\__ \\| |_) || |    | || | | || (_| |  | |_) || (_| || |_ | (__ | | | |		\n");
		sbf.append("       |___/| .__/|_|   |_||_||_| \\__, |  |_.__/ \\__,_| \\__|\\___||_| |_|	\n");
		sbf.append("              | |                          __/  |                                    				\n");
		sbf.append("              |_|                         |___/                                     				\n");
		sbf.append("                                                                                          				\n");
		sbf.append(":: Welcome to the cowboy76 project________________________________   \n");
		log.info("{}", sbf.toString());

	}
}
