package com.irojas.microservices.customer_microservice.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <--- ESTO ES VITAL PARA SQL
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String nombre;
    private String pais;
    private Integer saldo;
    @Temporal(TemporalType.TIMESTAMP) // Recomendado para manejar fechas en SQL
    private Date fecha_registro;
    private String estado;
}
