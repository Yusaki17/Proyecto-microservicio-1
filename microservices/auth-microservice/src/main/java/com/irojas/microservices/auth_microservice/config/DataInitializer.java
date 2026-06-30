package com.irojas.microservices.auth_microservice.config;

import com.irojas.microservices.auth_microservice.user.Role;
import com.irojas.microservices.auth_microservice.user.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepository) {
        return args -> {
            List<String> roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");

            roles.forEach(roleName -> {
                if (roleRepository.findByName(roleName).isEmpty()) {
                    roleRepository.save(new Role(null, roleName));
                    System.out.println("✅ Rol creado: " + roleName);
                }
            });
        };
    }
}