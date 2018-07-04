package com.forezp;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootElkApplication {

	private static Logger LOGGER = Logger.getLogger(SpringbootElkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootElkApplication.class, args);
		for(int i = 0; i < 1000; i ++){
			LOGGER.info("i is " + i);
		}
	}

}
