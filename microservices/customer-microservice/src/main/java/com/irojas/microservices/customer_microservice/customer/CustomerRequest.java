package com.irojas.microservices.customer_microservice.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record CustomerRequest(
        Integer id,
        @NotBlank(message = "Colocar el usuario")
        String username,
        @NotBlank(message = "Coloque su email")
        String email,
        @NotBlank(message = "ingrese la contraseña")
        String password,
        @NotBlank(message = "Ingrese su nombre real")
        String nombre,
        @NotBlank(message = "Ingrese su pais")
        String pais,
        @NotNull(message = "Saldo que tiene")
        Integer saldo,

        @NotNull(message = "fecha de registro")
        @JsonFormat(pattern = "yyyy-MM-dd") // <--- AGREGA ESTO
        Date fecha_registro,

        @NotBlank(message = "Estado del usuario")
        String estado
) { }

