package com.thoma.finmanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.thoma.finmanapi")
public class FinmanapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinmanapiApplication.class, args);
	}

}
