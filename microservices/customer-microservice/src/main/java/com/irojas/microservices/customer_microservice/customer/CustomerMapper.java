package com.irojas.microservices.customer_microservice.customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .id(request.id())
                .username(request.username())
                .email(request.email())
                .password(request.password())
                .nombre(request.nombre())
                .pais(request.pais())
                .saldo(request.saldo())
                .fecha_registro(request.fecha_registro())
                .estado(request.estado())
                .build();
    }
    public CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .nombre(customer.getNombre())
                .pais(customer.getPais())
                .saldo(customer.getSaldo())
                .fecha_registro(customer.getFecha_registro())
                .estado(customer.getEstado())
                .build();
    }
}

