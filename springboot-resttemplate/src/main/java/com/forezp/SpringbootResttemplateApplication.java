package com.forezp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootResttemplateApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootResttemplateApplication.class);

//	public static void main(String args[]) {
//		RestTemplate restTemplate = new RestTemplate();
//		String quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
//		log.info(quote.toString());
//	}

	public static void main(String args[]) {
		SpringApplication.run(SpringbootResttemplateApplication.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", String.class);
			log.info(quote.toString());
		};
	}
}
