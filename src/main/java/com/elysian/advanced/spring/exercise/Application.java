package com.elysian.advanced.spring.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	// insert DB values only once
	/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "MANAGER"));
			userService.saveRole(new Role(null, "ADMIN"));
			userService.saveRole(new Role(null, "SUPER_ADMIN"));

			userService.saveUser(new User(null, "User1", "user1", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "User2", "user2", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "User3", "user3", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "User4", "user4", "1234", new ArrayList<>()));

			userService.addRoleToUser("user1", "USER");
			userService.addRoleToUser("user1", "MANAGER");
			userService.addRoleToUser("user1", "ADMIN");
			userService.addRoleToUser("user1", "SUPER_ADMIN");
			userService.addRoleToUser("user2", "USER");
			userService.addRoleToUser("user3", "USER");
			userService.addRoleToUser("user4", "USER");
		};
	}*/

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}