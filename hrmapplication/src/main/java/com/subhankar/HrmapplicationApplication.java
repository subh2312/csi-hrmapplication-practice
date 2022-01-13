package com.subhankar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "hrmApp", scheme = "basic", type = SecuritySchemeType.HTTP, in= SecuritySchemeIn.HEADER )
public class HrmapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmapplicationApplication.class, args);
	}

}
