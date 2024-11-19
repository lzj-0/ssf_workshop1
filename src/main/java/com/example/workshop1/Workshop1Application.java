package com.example.workshop1;

import java.util.Collections;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop1Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Workshop1Application.class);
		

		String port = "3000";
		DefaultApplicationArguments cliOpts = new DefaultApplicationArguments(args);

		if (cliOpts.containsOption("port")) {
			port = cliOpts.getOptionValues("port").get(0);
			// System.setProperty("server.port", port);	// this overwrites the environment variable SERVER_PORT
		} else if (System.getenv("PORT") != null) {
			port = System.getenv("PORT");
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));

		System.out.println("Running on port: " + port);
		app.run(args);
	}

}
