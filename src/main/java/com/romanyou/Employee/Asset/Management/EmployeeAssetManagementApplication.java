package com.romanyou.Employee.Asset.Management;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Employee Asset Management API", version = "1.0.0"),
		servers = {@Server(url = "http://localhost8080"), @Server(url = "http://example.com")},
		tags = {@Tag(name = "Employee", description = "This is Employee Controller End Points ")}
)
public class EmployeeAssetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAssetManagementApplication.class, args);
	}

}
