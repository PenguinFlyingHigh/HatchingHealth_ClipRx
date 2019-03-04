package com.hatch.med_adhere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = { MedAdhereApplication.class})
public class MedAdhereApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedAdhereApplication.class, args);
	}

}
