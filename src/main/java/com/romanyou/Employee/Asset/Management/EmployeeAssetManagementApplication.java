package com.romanyou.Employee.Asset.Management;

import com.romanyou.Employee.Asset.Management.user.entity.AppUser;
import com.romanyou.Employee.Asset.Management.user.entity.Role;
import com.romanyou.Employee.Asset.Management.user.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Employee Asset Management API", version = "1.0.0"),
		servers = {@Server(url = "http://localhost8080"), @Server(url = "http://example.com")},
		tags = {@Tag(name = "Employee", description = "This is Employee Controller End Points ")}
)
@CrossOrigin()
public class EmployeeAssetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAssetManagementApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "Roman Behroz", "roman","123", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Hoda Yousof", "hoda","123", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Mehral Behroz", "mehral","123", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Elena Yousof", "elena","123", new ArrayList<>()));


			userService.addRoleToUser("roman", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("hoda", "ROLE_ADMIN");
			userService.addRoleToUser("hoda", "ROLE_MANAGER");
			userService.addRoleToUser("mehral", "ROLE_USER");
			userService.addRoleToUser("elena", "ROLE_USER");
		};
	}


}
